package com.lti.bank.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="account")
public class Account {
	
	@Id
	@SequenceGenerator(name="mysequence", initialValue=1000)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="mysequence")
	Long accountId;
	@Column(name="balance_amount")
	Double balanceAmount;
	@Column(name="isApproved")
	int isApproved;
	
	@OneToOne
	@JoinColumn(name="customerId")
	Customer customer;
	
	public Account(Long accountId, Double balanceAmount, int isApproved, Customer customer) {
		super();
		this.accountId = accountId;
		this.balanceAmount = balanceAmount;
		this.isApproved = isApproved;
		this.customer = customer;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Double getBalanceAmount(){
		return balanceAmount;
	}
	public void setBalanceAmount(Double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}
	public int getIsApproved() {
		return isApproved;
	}
	public void setIsApproved(int isApproved) {
		this.isApproved = isApproved;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(Double balanceAmount, int isApproved) {
		super();
		this.balanceAmount = balanceAmount;
		this.isApproved = isApproved;
	}
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

}
