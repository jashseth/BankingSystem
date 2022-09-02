package com.lti.bank.model;

import javax.persistence.*;

@Entity
@Table(name = "UserRegister")
public class User {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	Long userid;
	Long accountNumber;
	String password;
	String transactionPassword;
	
	
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTransactionPassword() {
		return transactionPassword;
	}
	public void setTransactionPassword(String transactionPassword) {
		this.transactionPassword = transactionPassword;
	}
	
	

}
