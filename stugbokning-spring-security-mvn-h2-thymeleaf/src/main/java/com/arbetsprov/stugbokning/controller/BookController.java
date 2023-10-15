//package com.arbetsprov.stugbokning.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import com.arbetsprov.stugbokning.model.Book;
//import com.arbetsprov.stugbokning.service.BookService;
//
//@Controller
//public class BookController {
//	
//	private BookService bookService;
//	
//	public BookController(BookService bookService) {
//		super();
//		this.bookService = bookService;
//	}
//	
//	@GetMapping("/")
//	public String viewHomePage(Model model) {
//		model.addAttribute("listBooks", bookService.getAllBooks());
//		return "index";
//	}
//	
//	@GetMapping("/showNewBookForm")
//	public String showNewBookForm(Model model) {
//		// create model attribute to bind form data
//		Book book = new Book();
//		model.addAttribute("book", book);
//		return "new_book";
//	}
//	
//	@PostMapping("/saveBook")
//	public String saveBook(@ModelAttribute(value = "book") Book book) {
//		
//		bookService.saveBook(book);
//		return "redirect:/";
//	}
//	
//	@GetMapping("/showFormForUpdate/{id}")
//	public String showFormForUpdate(@PathVariable(value = "id") Integer id, Model model) {
//		
//		Book book = bookService.getBookById(id);
//		
//		model.addAttribute("book", book);
//		
//		return "update_book";
//	}
//	
//	@GetMapping("/deleteBook/{id}")
//	public String deleteBook(@PathVariable(value = "id") Integer id, Model model) {
//		
//		bookService.deleteBookById(id);	
//		
//		return "redirect:/";
//	}
//
////	@PostMapping("/saveBook")
////	public void saveBook(@RequestBody Book book) {
//////		Book book = new Book("Spring Boot", 11, "Chotan");
////		
////		bookService.saveBook(book);
////	}
//	
////	@GetMapping("/showAllBooks")
////	public List<Book> showAllBooks() {
////		return bookService.getAllBooks();
////	}
//
//}
