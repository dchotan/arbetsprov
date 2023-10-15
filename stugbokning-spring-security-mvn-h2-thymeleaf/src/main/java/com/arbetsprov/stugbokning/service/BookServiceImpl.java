package com.arbetsprov.stugbokning.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.arbetsprov.stugbokning.model.Book;
import com.arbetsprov.stugbokning.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{

	private BookRepository bookRepository;	
	
	public BookServiceImpl(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	@Override
	public void saveBook(Book book) {
		bookRepository.save(book);		
	}

	@Override
	public List<Book> getAllBooks() {	
		List<Book> books = bookRepository.findAll();
		return books;
	}

	@Override
	public Book getBookById(Integer id) {
		Optional<Book> optional = bookRepository.findById(id);
		Book book = null;
		if(optional.isPresent()) {
			book = optional.get();
		}
		else {
			throw new RuntimeException("Book does not found for id: " + id);
		}
		
		return book;
	}

	@Override
	public void deleteBookById(Integer id) {
		bookRepository.deleteById(id);		
	}

}
