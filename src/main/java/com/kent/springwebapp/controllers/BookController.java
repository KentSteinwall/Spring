package com.kent.springwebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kent.springwebapp.repositories.BookRepository;

@Controller
public class BookController {
	
	private BookRepository bookRepository;
	

	public BookController(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}


	@RequestMapping("/books")
	public String getBooks(Model model) {
		
		model.addAttribute("books",bookRepository.findAll());
		return "books";
		
	}
	   
}
