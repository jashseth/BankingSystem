package com.lti.bank.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.lti.bank.model.Beneficiary;

@Repository
public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Long> {
	
	@Query("select b from Beneficiary b where account.accountId=:accountId")
	public List<Beneficiary> getBeneficiaryByAccountId(@Param("accountId") Long accountId);
	
	
}
