package com.arbetsprov.stugbokning.service;

import java.util.List;

import com.arbetsprov.stugbokning.model.Book;

public interface BookService {
	
	void saveBook(Book book);
	List<Book> getAllBooks();
	Book getBookById(Integer id);
	void deleteBookById(Integer id);
}
