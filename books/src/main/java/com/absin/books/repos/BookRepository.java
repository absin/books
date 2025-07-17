package com.absin.books.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.absin.books.entities.Books;

public interface BookRepository extends CrudRepository<Books, Long> {

	List<Books> findAll();

}
