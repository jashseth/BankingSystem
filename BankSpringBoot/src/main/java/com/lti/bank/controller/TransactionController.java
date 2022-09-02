package com.lti.bank.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.lti.bank.exception.RecordNotFoundException;
import com.lti.bank.model.TransactionFilter;
import com.lti.bank.model.Transactions;
import com.lti.bank.repo.TransactionRepository;
import com.lti.bank.service.TransactionService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class TransactionController{
	
	
	@Autowired
	private TransactionService transactionService;
	
	
	@PostMapping("/transaction")
	public ResponseEntity<?> addTransaction(@Valid @RequestBody Transactions trans) {
		
		
		return transactionService.createTransaction(trans);	
		
//		return transactionRepository.save(trans);			
	}
	
	@GetMapping("/transaction")
	public List<Transactions> getAllTransactions(){
		
		List<Transactions> lt=transactionService.getAllTransactions();
		
		return lt;
	}
	
	@GetMapping("/transaction/{id}")
	public Transactions getTransactionById(@PathVariable("id") Long id) throws RecordNotFoundException{
		
		Transactions t=transactionService.getTransactionsById(id);
		
		return t;
		
	}
	
	@PostMapping("/transactionFilter")
	public List<Transactions> filterTransactionByDate(@Valid @RequestBody TransactionFilter transactionFilter){

		
		return transactionService.filterTransactions(transactionFilter);
	}
	
	
	
	
	

}
