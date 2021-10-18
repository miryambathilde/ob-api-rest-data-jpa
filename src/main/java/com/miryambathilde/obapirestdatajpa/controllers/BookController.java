package com.miryambathilde.obapirestdatajpa.controllers;

import com.miryambathilde.obapirestdatajpa.entities.Book;
import com.miryambathilde.obapirestdatajpa.repositories.BookRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class BookController {

    // atributos
    private BookRepository bookRepository;

    // constructor
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /** CRUD sobre la entidad Book **/
    //TOMCAT: http://localhost:8080 //

    // 1. Buscar todos los libros (lista de libros)

    /**
     * http://localhost:8080/api/books
     *
     * @return
     */
    @GetMapping("/api/books")
    public List<Book> findBooks() {
        // recuperar y devolver los libros de la base de datos //
        // tenemos que CREAR el ATRIBUTO + CONTROLADOR de bookrepository para que sea accesible desde el controlador //
        return bookRepository.findAll();
        // luego añadimos antes del método el @GetMapping("/api/books") //
    }

    // 2. Buscar un solo libro por ID

    /**
     * http://localhost:8080/api/books/id
     * Request
     * Response
     * @param id
     * @return
     */
    @GetMapping("/api/books/{id}")
    // como el parametro id es variable tenemos que poner la notacion @PathVariable
    // ResponseEntity<Book>
    public ResponseEntity<Book> findOneById(@PathVariable Long id) {
        // le ponemos opcional y devuelve un Book
        Optional<Book> bookOptional = bookRepository.findById(id);
        // 1. opcion 1
        if(bookOptional.isPresent())
            return ResponseEntity.ok(bookOptional.get()); // esto nos devuelve el libro
        else
            return ResponseEntity.notFound().build(); // esto responde 404
    }

    // 3. Crear un nuevo libro en base de datos

    @PostMapping("/api/books")
    public Book create(@RequestBody Book book, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));
        //guardar libro recibido por parametro en la base de datos
        return bookRepository.save(book);
    }

    // 4. Actualizar un libro existente en base de datos

    // 5. Borrar un libro de la base de datos
}
