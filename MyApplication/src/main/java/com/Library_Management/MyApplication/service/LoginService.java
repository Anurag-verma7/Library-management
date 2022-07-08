package com.Library_Management.MyApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Library_Management.MyApplication.dao.LoginRepository;
import com.Library_Management.MyApplication.model.User;

@Service
public class LoginService {
	@Autowired
    LoginRepository Loginrepository;
	
	public User loginuser(User user) {
		//System.out.println(user);
		User user1 = Loginrepository.findByEmail(user.getEmail());
		System.out.println(user1.getUserType());
		if(user1.getPassword().equals(user.getPassword())) {
			return user1;
			
	}
		return null;
}
}
