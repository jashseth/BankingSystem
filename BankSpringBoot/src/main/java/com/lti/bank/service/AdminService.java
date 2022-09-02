package com.lti.bank.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lti.bank.model.Admin;
import com.lti.bank.model.AdminLogin;
import com.lti.bank.model.User;
import com.lti.bank.repo.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	
	public ResponseEntity<?> addAdmin(Admin admin) {
		System.out.println("Inside Service Layer");
		
		Map<String, Object> map=new LinkedHashMap<>();
		
        Admin a = adminRepository.findByAdminUsername(admin.getAdminUsername());
		
		if(a!=null) {
			map.put("success", false );
			map.put("message", "Admin already Exist");
			return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
		}
		
		Admin as = adminRepository.save(admin);
		
		map.put("success", true );
		map.put("body", as);
		return new ResponseEntity<>(map,HttpStatus.OK);
		
			
			
	}
	
	
     public String adminlogin(AdminLogin adminLogin){
		
		String username=adminLogin.getAdminUsername();
		String password=adminLogin.getAdminPassword();
		
		Admin ad= adminRepository.findByAdminUsername(adminLogin.getAdminUsername());
		
		if(ad==null) {
			
			return "Admin not found !";
			
		}
		else if(ad.getAdminPassword().equals(password)) {
			return "Admin Logged In Successful";
		}
		else {
			return "usename or password Incorrect";
		}
		
		
	}

}
