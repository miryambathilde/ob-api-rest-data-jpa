package com.miryambathilde.obapirestdatajpa;

import com.miryambathilde.obapirestdatajpa.entities.Book;
import com.miryambathilde.obapirestdatajpa.repositories.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class ObApiRestDataJpaApplication {

	public static void main(String[] args) {
		// 1. añadimos contexto
		ApplicationContext context = SpringApplication.run(ObApiRestDataJpaApplication.class, args);
		// 2. le decimos que dentro de nuestro contexto recupere el Bean del repositorio para que lo escanee
		BookRepository repository = context.getBean(BookRepository.class);

		/** CRUD **/
		// 1. crear libro
		Book book1 = new Book(null, "Homo Deus", "Yuval Noah", 450, 29.99, LocalDate.of(2018, 12, 1), true);
		Book book2 = new Book(null, "Homo Deus", "Yuval Noah", 320, 19.99, LocalDate.of(2013, 12, 1), true);

		// guardar libro - save()
		System.out.println("Número de libros en base de datos: " + repository.findAll().size());
		repository.save(book1);
		repository.save(book2);

		// recuperar todos los libros - findAll()
		System.out.println("Número de libros en base de datos después de añadir libros: " + repository.findAll().size());

		// borrar un libro - deleteById - y le pasamos el id + L, porque es un (Long)
		repository.deleteById(1L);
		System.out.println("Número de libros en base de datos después de borrar libro: " + repository.findAll().size());
	}
}
