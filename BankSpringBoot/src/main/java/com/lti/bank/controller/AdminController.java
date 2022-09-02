package com.lti.bank.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lti.bank.model.Admin;
import com.lti.bank.model.AdminLogin;
import com.lti.bank.model.Customer;
import com.lti.bank.service.AdminService;

@RestController
@CrossOrigin
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/admin")
	public ResponseEntity<?> addAdmin(@Valid @RequestBody Admin admin) {
		return adminService.addAdmin(admin);
	}
	
	
	@PostMapping("/adminLogin")
	public String adminLogin(@Valid @RequestBody AdminLogin admLogin) {
		return adminService.adminlogin(admLogin);
	}

}
