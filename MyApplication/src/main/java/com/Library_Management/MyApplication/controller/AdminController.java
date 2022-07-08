package com.Library_Management.MyApplication.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Library_Management.MyApplication.model.Book;
import com.Library_Management.MyApplication.model.User;
import com.Library_Management.MyApplication.service.AdminService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired 
	AdminService adminService;
	
	@GetMapping("/availablebooks")
	List<Book> getAllBooks(){
		return adminService.findAllBooks();
	}
	
	@PostMapping("/createuser")
	public User createUser(@RequestBody User user) {
		return adminService.createUser(user);
	}
	
	@DeleteMapping("/removeuser/{userId}")
	public boolean deleteUser(@PathVariable int userId) {
		return adminService.deleteUser(userId);
	}
	
	@PostMapping("/addbook")
	public Book createUser(@RequestBody Book book) {
		return adminService.addBook(book);
	}
	
	@DeleteMapping("/removebook/{bookId}")
	public boolean deleteBook(@PathVariable int bookId) {
		return adminService.deleteBook(bookId);
	}
	
	@GetMapping("getbooks/{userId}")
	public List<Book> getBooksByUserId(@PathVariable int userId){
		return adminService.getBooksByUser(userId);
	}
	
	@GetMapping("/getlendingbooks")
	public List<Book> getAllLendedBooks(){
		return adminService.getAllLendedBooks();
	}
	
	@GetMapping("/getuserbybookname/{bookName}")
	public List<User> getAllUserByBookName(@PathVariable String bookName){
		return adminService.getAllUserByBookName(bookName);	
	}
	
	
	
	

}
