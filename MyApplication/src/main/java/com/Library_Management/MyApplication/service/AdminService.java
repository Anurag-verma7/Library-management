package com.Library_Management.MyApplication.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Library_Management.MyApplication.dao.BookRepository;
import com.Library_Management.MyApplication.dao.UserRepository;
import com.Library_Management.MyApplication.model.Book;
import com.Library_Management.MyApplication.model.User;

@Service
public class AdminService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BookRepository bookRepository;

	public User createUser(User user) {
		user.setDeleted(false);
		return userRepository.save(user);
	}

	public Boolean deleteUser(int userId) {
		try {
		    User user = userRepository.getById(userId);
		    user.setDeleted(true);
		    userRepository.save(user);
		    return true;
			
		}
		catch(Exception e) {
			return false;
		}
	}

	public Book createBook(Book book) {
		return bookRepository.save(book);
	}

	public boolean deleteBook(int bookId) {
		try {
		    bookRepository.delete(bookRepository.getById(bookId));
		    return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	public Book addBook(Book book) {
		return bookRepository.save(book);
		//return bookRepository.addBook(book);
	}

	public List<Book> getBooksByUser(int userId) {
		return bookRepository.getBorrowedBooks(userId);
	}

	public List<Book> getAllLendedBooks() {
		return bookRepository.getAllLendedBooks();
	}

	public List<User> getAllUserByBookName(String bookName) {
		return bookRepository.getAllUserByBookName(bookName);
	}

	public List<Book> findAllBooks() {
		List<Book> Allbooks =bookRepository.findAll();
		return Allbooks;
	}
	

}
