package com.Library_Management.MyApplication.dao;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import com.Library_Management.MyApplication.model.User;

@Repository
public class UserRepository extends SimpleJpaRepository<User, Integer> {

	public UserRepository(EntityManager em) {
		super(User.class, em);
	}

}
