package com.Library_Management.MyApplication.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.AbstractJpaQuery;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import com.Library_Management.MyApplication.model.Book;
import com.Library_Management.MyApplication.model.Lending;
import com.Library_Management.MyApplication.model.User;


@Repository
public class BookRepository extends SimpleJpaRepository<Book, Integer> {
	@Autowired
	private EntityManager entityManager;
	
	public BookRepository(EntityManager em) {
		super(Book.class, em);
	}

	public List<Book> getBorrowedBooks(int userid) {

		Query q = entityManager.createNativeQuery("SELECT  B.book_id,B.book_name,B.author_name,B.no_of_copies FROM BOOK AS B ,LENDING AS L WHERE B.BOOK_ID = L.BOOKID AND L.USERID = " + userid);
		List<Object[]> lendedBooks =(List<Object[]>)q.getResultList();
		List<Book> actual=new ArrayList<>(lendedBooks.size());
		for(Object[] o:lendedBooks) {
			Book b=new Book((int)o[0],(String)o[1],(String)o[2],(int)o[3]);
			actual.add(b);
			
		}
		
		//System.out.print(lendedBooks.size());
		
		return actual;
		
	}

	public List<Book> getOverDueBooks(int userId) {
		
		Query q = entityManager.createNativeQuery("SELECT * FROM BOOK AS B ,LENDING AS L WHERE B.BOOK_ID = L.BOOKID AND L.RETURNDATE < NOW() AND L.USERID = " + userId);
		List<Book> overDueBooks = q.getResultList();
		return overDueBooks;
	
	}

	public List<Book> getAllLendedBooks() {
		
		Query q = entityManager.createNativeQuery("SELECT B.book_id,B.book_name,B.author_name,B.no_of_copies FROM BOOK AS B ,LENDING AS L WHERE B.BOOK_ID = L.BOOKID AND L.ISRETURNED = 0");
		List<Object[]> lendedBooks =(List<Object[]>)q.getResultList();
		List<Book> actual=new ArrayList<>(lendedBooks.size());
		for(Object[] o:lendedBooks) {
			Book b=new Book((int)o[0],(String)o[1],(String)o[2],(int)o[3]);
			actual.add(b);
			
		}
		
		//System.out.print(lendedBooks.size());
		
		return actual;
	}

	public List<User> getAllUserByBookName(String bookName) {
		Query q = entityManager.createNativeQuery("SELECT U.USER_ID, U.USER_NAME,  FROM USER AS U, LENDING AS L, BOOK AS B WHERE L.USERID = U.USER_ID AND L.ISRETURNED = 0 AND B.BOOK_ID = L.BOOKID AND B.BOOK_NAME = '" + bookName + "'");
		List<User> users = q.getResultList();
		return users;
	}

	
	
	

	
	
}
