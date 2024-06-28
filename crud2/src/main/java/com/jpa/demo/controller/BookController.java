package com.jpa.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.demo.model.Book;
import com.jpa.demo.service.BookService;

@RestController
@RequestMapping("/api")
public class BookController {

@Autowired
 public BookService bookService;

@PostMapping("/book")
public String addDetails(@RequestBody Book book) {
	bookService.addDetails(book);
	return "SUCCESS";
}

@GetMapping("/book")
public List<Book> getAll(){
	List<Book> book=null;
	book=bookService. getAll();
	return book;	
}

@GetMapping("/book/{bookno}")
public Optional <Book> getById(@PathVariable int  bookno){
	System.out.println(bookno);
	Optional <Book> book=null;
	book= bookService.getById(bookno);
	return book;
}

@DeleteMapping("/book/{bookno}")
public String deletebyid(@PathVariable int bookno) {
	bookService.deletebyid(bookno);
	return "DELETED SUCCESFULLY";
}
@PutMapping("/book/{bookno}")

public String bookUpdate(@PathVariable int bookno, @RequestBody Book book) {
	
    bookService.updateBook(bookno,book);
    return "Book updated successfully";
}
}

