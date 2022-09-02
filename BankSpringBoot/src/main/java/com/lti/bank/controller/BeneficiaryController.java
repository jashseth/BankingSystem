package com.lti.bank.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.bank.model.Beneficiary;
import com.lti.bank.service.BeneficiaryService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class BeneficiaryController {
	
	@Autowired
	private BeneficiaryService beneficiaryService;
	
	@PostMapping("/beneficiary")
	public Beneficiary createBeneficiary(@Valid @RequestBody Beneficiary beneficiary) {
		
		return beneficiaryService.createBeneficiary(beneficiary);
	}
	
	@GetMapping("/beneficiary")
	public List<Beneficiary> getAllBeneficiary(){
		return beneficiaryService.getAllBeneficiary();
	}
	
	@GetMapping("/beneficiary/{id}")
	public List<Beneficiary> getBeneficiaryByAccountId(@PathVariable("id") Long accountId){
		return beneficiaryService.getBeneficiaryByAccountId(accountId);
		
	}

}
