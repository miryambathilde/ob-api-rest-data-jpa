package com.miryambathilde.obapirestdatajpa.controllers;

import com.miryambathilde.obapirestdatajpa.entities.Book;
import com.miryambathilde.obapirestdatajpa.repositories.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
     * @return
     */
    @GetMapping("/api/books")
    public List<Book> findBooks(){
        // recuperar y devolver los libros de la base de datos //
        // tenemos que CREAR el ATRIBUTO + CONTROLADOR de bookrepository para que sea accesible desde el controlador //
        return bookRepository.findAll();
        // luego añadimos antes del método el @GetMapping("/api/books") //
    }

    // 2. Buscar un solo libro por ID
    //public Book findOneById(Long id){

    }

    // 3. Crear un nuevo libro en base de datos

    // 4. Actualizar un libro existente en base de datos

    // 5. Borrar un libro de la base de datos

