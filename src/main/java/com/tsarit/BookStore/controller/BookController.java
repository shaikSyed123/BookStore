package com.tsarit.BookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tsarit.BookStore.model.Book;
import com.tsarit.BookStore.model.MyBookList;
import com.tsarit.BookStore.service.BookService;
import com.tsarit.BookStore.service.MyBookService;

@Controller
public class BookController {
    
	@Autowired
	private BookService service;
	
	@Autowired
	private MyBookService mybookservice;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	@GetMapping("/book_register")
	public String bookregister() {
		return "bookregister";
	}
	
	@GetMapping("/avilable_book")
	public ModelAndView getAllBook() {
		 List<Book> list=service.getAllBook();
		 ModelAndView m=new ModelAndView();
		 m.setViewName("booklist");
		 m.addObject("book",list);
		return m;
	}
	
	@PostMapping("/save")
   public String addBook(@ModelAttribute Book b) {
	   service.save(b);
	   return "redirect:/avilable_book";
   }
	
	@GetMapping("/my_books")
	public String getMyBooks(Model model) {
		List<MyBookList> list=mybookservice.getAllMyBooks();
		model.addAttribute("book",list);
		return "myBooks";
	}
	
	
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Book b=service.getBookById(id);
		MyBookList mb=new MyBookList(b.getId(),b.getBookname(),b.getAuthor(),b.getPrice());
		mybookservice.saveMyBook(mb);
		return "redirect:/my_books";
	}
	
	@RequestMapping("/editbook/{id}")
	public String editBook(@PathVariable("id")int id,Model model) {
	    Book b=service.getBookById(id);
	    model.addAttribute("book",b);
		return "bookedit";
	}
	@RequestMapping("/deletebook/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		service.deleteById(id);
		return "redirect:/avilable_book";
	}
	
}
