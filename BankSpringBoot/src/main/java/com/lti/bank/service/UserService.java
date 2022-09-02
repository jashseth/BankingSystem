package com.lti.bank.service;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lti.bank.model.Login;
import com.lti.bank.model.TransactionValidate;
import com.lti.bank.model.User;
import com.lti.bank.repo.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	
	public ResponseEntity<?> addUser(User user) {
		System.out.println("Inside Service Layer");
		
		Map<String, Object> map=new LinkedHashMap<>();
		
        User u = userRepo.findByAccountNumber(user.getAccountNumber());
		
		if(u!=null) {
			map.put("success", false );
			map.put("message", "User already Exist");
			return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
		}
		
		User us = userRepo.save(user);
		
		map.put("success", true );
		map.put("body", us);
		return new ResponseEntity<>(map,HttpStatus.OK);
		
			
			
	}
	
	public List<User> getAllUser(){
		
		return userRepo.findAll();
		
	}
	
	
	public String login(Login login) {
		
        long a = login.getAccountNumber();
		
		String p = login.getPassword();
		
		List<User> ls = userRepo.findAll();
		
		for(User u : ls) {
			
//			System.out.println(u.getAccountNumber());
			
			if(u.getAccountNumber()==a && u.getPassword().equals(p)) {
//				System.out.println(u.getPassword());
				return "{\"status\":\"True\"}";
			}
		}
		return "{\"status\":\"False\"}";
		
		
		
	}
	
	
	public String validateTransaction(TransactionValidate trans){
		
		
		
		User u=userRepo.findByAccountNumber(trans.getAccountId());
		
		if(u.getTransactionPassword().equals(trans.getPassword())) {
			return "{\"status\":\"True\"}";
		}else {
			return "{\"status\":\"False\"}";
			
		}
	}

}
