package com.bookclub.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.bookclub.models.Book;
import com.bookclub.models.User;
import com.bookclub.services.BookService;
import com.bookclub.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookServ;
	@Autowired
	private UserService userServ;

	@GetMapping("/books")
	public String home(Model m, HttpSession s) {
		Long userId = (Long) s.getAttribute("user_id");
    	if(userId == null) {
    		return "redirect:/";
    	}else {    		
    		User userIn = userServ.findUser(userId);
    		m.addAttribute("userIn",userIn);
    		List<Book> allTheBooks = bookServ.allBooks();
    		m.addAttribute("booksList", allTheBooks);
    		return "home.jsp";
    	}
	}
	
	@GetMapping("/books/new")
	public String create(@ModelAttribute("book") Book book, Model m, HttpSession s) {
		Long userId = (Long) s.getAttribute("user_id");
    	if(userId == null) {
    		return "redirect:/";
    	}else {   
    		User userIn = userServ.findUser(userId);
    		m.addAttribute("userIn",userIn);
    		return "create.jsp";
    	}
	}
	
	@PostMapping("/books")
	public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result,
							Model m,  HttpSession s) {
		
			Long userId = (Long) s.getAttribute("user_id");
    		User userIn = userServ.findUser(userId);
    	if (result.hasErrors()) {
    		m.addAttribute("userIn",userIn);
			return "create.jsp";
		} else {
			book.setPoster(userIn);
			Book newBook = bookServ.createBook(book);
			System.out.println(newBook);
			return "redirect:/books";
		}
		
	}
	
	@GetMapping("/books/{id}")
	public String oneBookShow(@PathVariable("id")Long id, Model m, HttpSession s) {
		Long userId = (Long) s.getAttribute("user_id");
    	if(userId == null) {
    		return "redirect:/";
    	}else {   
    		User userIn = userServ.findUser(userId);
    		m.addAttribute("userIn",userIn);
    		Book thisBook = bookServ.findBook(id);
    		m.addAttribute("book",thisBook);
    		return "showBook.jsp";
    	}
	}

	@GetMapping("books/{id}/edit")
	public String editPage(@PathVariable("id") Long id, Model model, HttpSession s) {
		Long userId = (Long) s.getAttribute("user_id");
    	if(userId == null) {
    		return "redirect:/";
    	}else { 
			Book thisBook = bookServ.findBook(id);
			model.addAttribute("book",thisBook);
			return "edit.jsp";
    	}
	}
	
	@PutMapping("/books/{id}/edit")
	public String updateBook(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession s) {
		Long userId = (Long) s.getAttribute("user_id");
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
    		User userIn = userServ.findUser(userId);
			book.setPoster(userIn);
			bookServ.updateBook(book);
			return "redirect:/books";
		}
	}
	
	@DeleteMapping("/books/{id}")
	public String delete(@PathVariable("id") Long id) {
		bookServ.deleteBook(id);
		return "redirect:/books";
	}
}
