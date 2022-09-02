package com.lti.bank.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lti.bank.model.Customer;
import com.lti.bank.service.CustomerService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PutMapping("/customer/{ei}")
	public Customer updateemployee(@PathVariable int ei,@RequestBody Customer e){
		return customerService.approveCustomer(ei,e);
	}
	
	@DeleteMapping("/customer/{ei}")
	public Customer delemployee(@PathVariable int ei) {
		return customerService.deleteCustomer(ei);
	} 
	
	@PostMapping("/customer")
	public String createCustomer(@Valid @RequestBody Customer cust) {
		
		return customerService.createCustomer(cust);
	}
	
	
	@GetMapping("/customer")
	public List<Customer> getAllCustomer(){
		return customerService.getAllCustomer();
	}
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<?> getCustomerById(@PathVariable Long id){
		
		return customerService.getCustomerById(id);
		
	}
	
	

}
