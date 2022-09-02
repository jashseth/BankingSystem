package com.lti.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lti.bank.model.Beneficiary;
import com.lti.bank.repo.BeneficiaryRepository;

@Service
public class BeneficiaryService {
	
	@Autowired
	private BeneficiaryRepository beneficiaryRepository;
	
	public Beneficiary createBeneficiary(Beneficiary beneficiary) {
		
		return beneficiaryRepository.save(beneficiary);
		
		
	}
	
	public List<Beneficiary> getAllBeneficiary(){
		
		return beneficiaryRepository.findAll();
	}
	
	
	public List<Beneficiary> getBeneficiaryByAccountId(Long accountId){
		
		
		
		return beneficiaryRepository.getBeneficiaryByAccountId(accountId);
		
		
	}
	
	
	

}
