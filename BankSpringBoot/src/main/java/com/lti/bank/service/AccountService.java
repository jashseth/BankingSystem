package com.lti.bank.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lti.bank.exception.RecordNotFoundException;
import com.lti.bank.model.Account;
import com.lti.bank.repo.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository  accountRepository;
	
	
	public String createAccount(Account acct) {
		 
		try {
			Account a=accountRepository.save(acct);
			return "{\"status\":\"Account Created Successfully\""
			+"\"Message\":\"Your Account Number is "+a.getAccountId()+" .Please note to register for Netbanking\"}";
		}
		catch(Exception e) {
			return "{\"status\":\"Error while creating account\"}";
		}
			
		
	}
	
	
	public int getStatusById(Long id) {
		int x= accountRepository.getStatusById(id);
		System.out.println(x);
		return x;
	}
	
	
	public List<Account> getAllAccount(){
		List<Account> al=accountRepository.findAll();
		
		return al;
	}
	
	public ResponseEntity<Account> getAccountByAccountId(Long id) throws RecordNotFoundException {
		
		
		Account a=accountRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Record  not found"));
		
		return ResponseEntity.ok(a);
//		Map<String, Object> map=new LinkedHashMap<>();
//		Optional<Account> a=accountRepository.findById(id);
//		
//		if(a.isEmpty()) {
//			map.put("Status", false);
//			map.put("Message", "No record found");
//			map.put("Result", null);
//			
//			return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST); 
//		}
//		
//		map.put("Status", true);
//		map.put("Message", "Account Found! ");
//		map.put("Result", a);
//		
//		
//		return new ResponseEntity<>(map,HttpStatus.OK); 
		
		
		
	}

}
