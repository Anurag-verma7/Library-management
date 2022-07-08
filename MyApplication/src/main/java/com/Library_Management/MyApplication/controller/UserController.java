package com.Library_Management.MyApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Library_Management.MyApplication.model.Book;
import com.Library_Management.MyApplication.model.Lending;
import com.Library_Management.MyApplication.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/availablebooks")
	List<Book> getAllBooks(){
		return userService.getAllBooks();
	}
	
    @GetMapping("/borrowedbooks/{userId}")
    List<Book> getBorrowedBooks(@PathVariable int userId){
    	return userService.getBorrowedBooks(userId);
    }
    
    @GetMapping("/overduebooks/{userId}")
    List<Book> getOverDueBooks(@PathVariable int userId){
    	return userService.getOverDueBooks(userId);
    }
    @PostMapping("/userborrowbook")
	public Lending addBookLending(@RequestBody Lending booklending) {
		return userService.addBookLending(booklending);
	}
   
}
