package com.Library_Management.MyApplication.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import com.Library_Management.MyApplication.model.Lending;

@Repository
public class BookLendingRepository extends SimpleJpaRepository<Lending,Integer> {
	@Autowired
	private EntityManager entityManager;
	
	public BookLendingRepository(EntityManager em) {
		super(Lending.class, em);
	
	}
}
