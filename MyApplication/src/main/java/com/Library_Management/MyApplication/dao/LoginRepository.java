package com.Library_Management.MyApplication.dao;



import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Repository;

import com.Library_Management.MyApplication.model.Book;
import com.Library_Management.MyApplication.model.User;

@Repository
public interface LoginRepository extends JpaRepository<User,Integer>{

	public User findByEmail(String email);
	
	
	
	
   
	}



	

	

	

