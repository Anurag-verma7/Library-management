package com.Library_Management.MyApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Library_Management.MyApplication.model.User;
import com.Library_Management.MyApplication.service.LoginService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
//@RequestMapping("/login")
public class LoginController {

@Autowired
LoginService Loginservice;

@PostMapping("/login")

public User LoginUser(@RequestBody User userData) {
	return Loginservice.loginuser(userData);
}

}
