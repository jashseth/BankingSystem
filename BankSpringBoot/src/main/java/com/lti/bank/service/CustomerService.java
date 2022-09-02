package com.lti.bank.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.bank.model.Account;
import com.lti.bank.model.Customer;
import com.lti.bank.repo.AccountRepository;
import com.lti.bank.repo.CustomerRepository;

@Service
public class CustomerService{
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
	
	@Transactional
	public Customer approveCustomer(long id, Customer c) {
		c.setStatus(1);
		Account ac=new Account();
		ac.setBalanceAmount(10000.0);
		ac.setIsApproved(1);
		ac.setCustomer(c);
		accountRepository.save(ac);
		//long x=c.getAccount().getAccountId();
		customerRepository.save(c);
		
//		Account ac=accountRepository.getReferenceById(x);
//		ac.setIsApproved(1);
//		accountRepository.save(ac);
		return c;
	}
	
	@Transactional
	public Customer deleteCustomer(long id) {
		Optional<Customer> em=customerRepository.findById((long) id);
		if(em.isPresent())
		{
			customerRepository.delete(em.get());
			return em.get();
			
		}
		else {
		return null;
		}
	}
	
	@Transactional
	public String createCustomer(Customer customer) {
		
        List<Customer> lu = customerRepository.findAll();
		
		Iterator<Customer> it = lu.iterator();
		int flag=0;
		while(it.hasNext()) {
			Customer c=it.next();
			if(c.getEmailId().equals(customer.getEmailId())) {
				flag=1;
				break;
			}
				else if(c.getMobileNumber()==customer.getMobileNumber()) {
					flag=2;
				}
				else if(c.getAadharNumber()==customer.getAadharNumber()) {
					flag=3;
				}
				else if(c.getPancardNumber()==customer.getPancardNumber()) {
					flag=4;
				}
			}
		
		switch(flag){
			case 1:
				return "{\"status\":\"Email already Exists\"}";
			case 2:
				return "{\"status\":\"Mobile Number already Exists\"}";
			case 3:
				return "{\"status\":\"Aadhar Number already Exists\"}";
			case 4:
				return "{\"status\":\"Pan Card Number already Exists\"}";
			default:
				
				
				System.out.println(customer.getCustomerId());
				
				Customer c=customerRepository.save(customer);
				
				return "{\"status\":\"Saved Sucessfully\",\n"
						+"\"customerId\":\""+customer.getCustomerId()+"\"}";
		}
	}
	
	public List<Customer> getAllCustomer(){
		
		//List<Customer> ls=customerRepository.findAll();
		
		return customerRepository.getAllCustomer();
		
	}
	
	public ResponseEntity<?> getCustomerById(Long custId){
		
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		try {
			Optional<Customer> user = customerRepository.findById(custId);
			map.put("status", 1);
			map.put("data", user);
			return new ResponseEntity<>(map, HttpStatus.OK);
		} catch (Exception ex) {
			map.clear();
			map.put("status", 0);
			map.put("message", "Data is not found");
			return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
	
	
	

}
