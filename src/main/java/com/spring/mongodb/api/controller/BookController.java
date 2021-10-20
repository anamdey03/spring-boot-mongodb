package com.spring.mongodb.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mongodb.api.model.Book;
import com.spring.mongodb.api.repository.BookRepository;

@RestController
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	
	@PostMapping("/addBook")
	public String saveBook(@RequestBody Book book) {
		bookRepository.save(book);
		return "Added book with id: " + book.getId();
	}
	
	@GetMapping("/findAllBooks")
	public List<Book> getBooks() {
		return bookRepository.findAll();
	}

	@GetMapping("/findBook/{id}")
	public Optional<Book> getBookById(@PathVariable int id) {
		return bookRepository.findById(id);
	}
	
	@DeleteMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable int id) {
		bookRepository.deleteById(id);
		return "Book deleted with id: " + id;
	}
}
