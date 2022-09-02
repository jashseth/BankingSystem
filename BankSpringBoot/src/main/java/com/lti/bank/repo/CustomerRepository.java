package com.lti.bank.repo;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lti.bank.model.Customer;
import com.lti.bank.model.Transactions;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	Customer findByEmailId(String emailId);
	Customer findByAadharNumber(long aadharNumber);
	Customer findByPancardNumber(String pancardNumber);
	Customer findByMobileNumber(long mobileNumber);
	
	@Query("select c from Customer c where status=0")
	public List<Customer> getAllCustomer();

}
