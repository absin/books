package com.absin.books.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.absin.books.entities.Books;
import com.absin.books.repos.BookRepository;

@Service
public class BookServiceImpl {

	@Autowired
	BookRepository bookRepository;

	public List<Books> getAllBooks() {
		return bookRepository.findAll();
	}

	public Books getBookById(Long id) throws NoSuchElementException {
		Optional<Books> byId = bookRepository.findById(id);
		if (byId.isPresent())
			return byId.orElseThrow();
		else
			throw new NoSuchElementException();
	}

	public Books createBook(Books books) {
		Books save = bookRepository.save(books);
		books.setId(save.getId());
		return books;
	}

	public Books updateBook(Books books) {
		Books save = bookRepository.save(books);
		return save;
	}

	public void deleteBookById(Long id) throws NoSuchElementException {
		Optional<Books> byId = bookRepository.findById(id);
		if (byId.isPresent())
			bookRepository.delete(bookRepository.findById(id).orElseThrow());
		else
			throw new NoSuchElementException();
	}

}
