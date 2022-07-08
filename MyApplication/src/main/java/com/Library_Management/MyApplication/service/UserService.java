package com.Library_Management.MyApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Library_Management.MyApplication.dao.BookLendingRepository;
import com.Library_Management.MyApplication.dao.BookRepository;
import com.Library_Management.MyApplication.model.Book;
import com.Library_Management.MyApplication.model.Lending;

@Service
public class UserService {
	
	@Autowired
	BookRepository bookRepository;
	@Autowired
	BookLendingRepository bookLendingRepository;

	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	public List<Book> getBorrowedBooks(int userid) {
		return bookRepository.getBorrowedBooks(userid);
	}

	public List<Book> getOverDueBooks(int userId) {
		return bookRepository.getOverDueBooks(userId);
	}

	public Lending addBookLending(Lending booklending) {
		return bookLendingRepository.save(booklending);
	
	}
	
	
	

}
