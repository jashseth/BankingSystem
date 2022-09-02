package com.lti.bank.service;

import java.util.HashMap;
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
import com.lti.bank.model.Beneficiary;
import com.lti.bank.model.TransactionFilter;
import com.lti.bank.model.Transactions;
import com.lti.bank.repo.AccountRepository;
import com.lti.bank.repo.BeneficiaryRepository;
import com.lti.bank.repo.TransactionRepository;

@Service
public class TransactionService {
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	BeneficiaryRepository br;
	
	public List<Transactions> getAllTransactions(){
		List<Transactions> transList=transactionRepository.findAll();
		
		return transList;
	}
	
	
	public ResponseEntity<?> createTransaction(Transactions trans) {
		
		
		
		Map<String, Object> map=new LinkedHashMap<>();
		
		Double accountbalance=accountRepository.getBalanceByAccountId(trans.getAccount().getAccountId());
		System.out.println(accountbalance);
		
		Beneficiary b=br.getReferenceById(trans.getBeneficiary().getBeneficiaryId());
		
		Account oa=accountRepository.getReferenceById(b.getBeneficiaryAccountNo());
		
		if(oa.equals(null))
		{
			map.clear();
			map.put("Success", false);
			map.put("message", "Account Doesn't Exist");
			map.put("Result", null);
			
			return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
		}
		
		Double benificiarybalance=accountRepository.getBalanceByAccountId(b.getBeneficiaryAccountNo());
		System.out.println(benificiarybalance);
		
		
		if(trans.getTransactionMode().equalsIgnoreCase("deposit")) {
			System.out.println("Deposited");
			
			accountbalance=accountbalance+trans.getAmount();
		    
			int n=accountRepository.updateAccountBalanceByAccountId(accountbalance,trans.getAccount().getAccountId());
			
			System.out.println(n);
			
			Transactions t=transactionRepository.save(trans);
			
			map.put("Success", true);
			map.put("Message", "Transaction Completed");
			map.put("Result", t);
			
			
			return new ResponseEntity<>(map,HttpStatus.OK);
			
		}
		else{
			System.out.println("Received");
			
			if(accountbalance<trans.getAmount()) {
				map.clear();
				map.put("Success", false);
				map.put("message", "Insufficient Funds");
				map.put("Result", null);
				
				return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
			}
			else{
			
			accountbalance=accountbalance-trans.getAmount();
			benificiarybalance=benificiarybalance+trans.getAmount();
			
			int n=accountRepository.updateAccountBalanceByAccountId(accountbalance,trans.getAccount().getAccountId());
			
			System.out.println(n);
			
			n=accountRepository.updateAccountBalanceByAccountId(benificiarybalance,b.getBeneficiaryAccountNo());
			
			System.out.println(n);
			
			Transactions t=transactionRepository.save(trans);
			
			map.clear();
			map.put("Success", true);
			map.put("Message", "Transaction Completed");
			map.put("Result", t);
			
			return new ResponseEntity<>(map,HttpStatus.OK);
			}
			
		}
		
		
		
	}
	
	
	public Transactions getTransactionsById(Long id) throws RecordNotFoundException {
		
		Optional<Transactions> tran=transactionRepository.findById(id);
		
		if(tran.isPresent()) {
			return tran.get();
		}
		else {
			throw new RecordNotFoundException("No transaction record found for given id: "+id);
		}
	}
	
	public List<Transactions> filterTransactions(TransactionFilter transactionFilter){
		
		return transactionRepository.getTransactionByDate(transactionFilter.getStartDate(), transactionFilter.getEndDate());
//		Map<String,Object> m=new LinkedHashMap<String,Object>();
		
		
//			List<Transactions> ft= transactionRepository.getTransactionByDate(transactionFilter.getStartDate(), transactionFilter.getEndDate());
			
//			if(ft.isEmpty()) {
//				m.put("Status", false);
//				m.put("Message", "No Transactions found between dates");
//				m.put("Result", null);
//				return new ResponseEntity<>(m,HttpStatus.NOT_FOUND);
//			}
//			m.put("status",1);
//			m.put("Message", "Transactions Found!");
//			m.put("Result", ft);	
//			return new ResponseEntity<>(m,HttpStatus.OK);
		
		
	}
	
	

	
}
