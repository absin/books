package com.absin.books.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.absin.books.entities.Books;
import com.absin.books.service.BookServiceImpl;

@RestController
@RequestMapping("/books")
public class BookController {
	private static final Logger log = LoggerFactory.getLogger(BookController.class);
	@Autowired
	BookServiceImpl bookService;

	@GetMapping("/api/books")
	List<Books> all() {
		return bookService.getAllBooks();
	}

	@GetMapping("/api/books/{id}")
	Books id(@PathVariable("id") Long id) {
		log.info("Reading book: " + id);
		try {
			return bookService.getBookById((id));
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found with ID: " + id);

		}
	}

	@PostMapping("/api/books")
	Books create(@RequestBody Books books) {
		return bookService.createBook(books);
	}

	@PutMapping("/api/books/{id}")
	Books update(@RequestBody Books books, @PathVariable("id") Long id) {
		books.setId(id);
		return bookService.updateBook(books);
	}

	@DeleteMapping("/api/books/{id}")
	void delete(@PathVariable("id") Long id) {
		log.info("Deleting book: " + id);
		try {
			bookService.deleteBookById(id);
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found with ID: " + id);

		}
	}
}
