package com.lti.bank.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.bank.exception.RecordNotFoundException;
import com.lti.bank.model.Account;
import com.lti.bank.service.AccountService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	
	@GetMapping("/accountstatus/{id}")
	public int getstatus(@PathVariable Long id) {
		return accountService.getStatusById(id);
	}
	
	@PostMapping("/account")
	public String createAccount(@Valid @RequestBody Account acct) {
		
		return accountService.createAccount(acct);
	}
	
	@GetMapping("/account")
	public List<Account> getAllAccount(){
		
		List<Account> al=accountService.getAllAccount();
		
		return al;
	}
	
	@GetMapping("/account/{id}")
	public ResponseEntity<Account> getAccountByAccountId(@PathVariable("id") Long id) throws RecordNotFoundException{
		
		return accountService.getAccountByAccountId(id);
	}
	
	

}
