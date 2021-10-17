package com.miryambathilde.obapirestdatajpa.repositories;

import com.miryambathilde.obapirestdatajpa.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

//JpaRepository nos permite tener todos los método CRUD + <id de la entidad + la clave primaria de nuestra entidad>

public interface BookRepository extends JpaRepository <Book, Long>{}
