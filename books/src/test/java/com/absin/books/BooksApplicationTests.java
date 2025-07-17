package com.absin.books;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.absin.books.entities.Books;
import com.absin.books.repos.BookRepository;

@SpringBootTest
class BooksApplicationTests {
	private static final Logger log = LoggerFactory.getLogger(BooksApplicationTests.class);
	@Autowired
	BookRepository bookRepository;

	@Test
	void contextLoads() {
		// Let's create a book entity persist it in H2 and then check if it has been
		// persisted or not
		List<Books> originalBooks = bookRepository.findAll();
		log.info("Originally there are " + originalBooks.size() + " books");
		Books books = new Books(null, "Thinking in Java", "Brude Eckel", 1991, "Computer Science");
		bookRepository.save(books);
		List<Books> newBooks = bookRepository.findAll();
		log.info("After saving there are " + newBooks.size() + " books");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
