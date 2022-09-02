package com.lti.bank.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.bank.model.Login;
import com.lti.bank.model.TransactionValidate;
import com.lti.bank.model.User;
import com.lti.bank.service.UserService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/registerUser")
	public ResponseEntity<?> addUser(@Valid @RequestBody User user){
		return userService.addUser(user);
	}
	
	@GetMapping("/userdetails")
	public List<User> userdetails(){
		List<User> ls = userService.getAllUser();
		return ls;
	}
	
	@PostMapping("/login")
	public String login(@Valid @RequestBody  Login login) {
		
		return userService.login(login);	
	}
	
	@PostMapping("/validateTransaction")
	public String validateTransaction(@Valid @RequestBody TransactionValidate trans) {
		
		return userService.validateTransaction(trans);
		
	}
	

}
