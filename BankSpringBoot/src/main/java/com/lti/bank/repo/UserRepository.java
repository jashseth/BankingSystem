package com.lti.bank.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lti.bank.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByAccountNumber(Long accountNo);
	
	

}
