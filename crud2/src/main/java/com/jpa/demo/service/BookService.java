package com.jpa.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.demo.Repo.BookRepository;
import com.jpa.demo.model.Book;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public void addDetails(Book book) {
    bookRepository.save( book);
	}
	
	public List<Book> getAll(){
	List<Book> book=null;
		book=bookRepository.findAll();
	return book;
		
	}
	
	public Optional <Book> getById(int bookno) {
		Optional<Book> book=null;
		book= bookRepository.findById(bookno);
		return book;
	}
	
	public void deletebyid(int bookno) {
		bookRepository.deleteById(bookno);
	}
		
	public Book  updateBook(int id, Book book) {
		 Book updateBook=bookRepository.findById(id).orElseThrow();
		 updateBook.setBookname(book.getBookname());
		 updateBook.setPrice(book.getPrice());
		
		return bookRepository.save(updateBook);
	}
	
}


