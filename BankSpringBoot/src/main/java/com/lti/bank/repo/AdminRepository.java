package com.lti.bank.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lti.bank.model.Admin;

public interface AdminRepository extends JpaRepository<Admin,Integer> {
	
	public Admin findByAdminUsername(String username);

}
