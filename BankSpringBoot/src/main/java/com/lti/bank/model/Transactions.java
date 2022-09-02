package com.lti.bank.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="transaction")
public class Transactions {
	
	@Id
	@SequenceGenerator(name="mysequence", initialValue=1000)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="mysequence")
	Long transactionId;
	@Column(name="transaction_mode")
	String transactionMode;
	@Column(name="transaction_type")
	String transactionType;
	@Column(name="date_of_transaction")
	@CreationTimestamp
	Date  dateOfTransaction; 
	@Column(name="Amount")
	Double amount;
	
	@ManyToOne
	Account account;
	
	@OneToOne
	Beneficiary beneficiary;
	
	
	
	public Transactions(Long transactionId, String transactionMode, String transactionType, Date dateOfTransaction,
			Double amount, Account account, Beneficiary beneficiary) {
		super();
		this.transactionId = transactionId;
		this.transactionMode = transactionMode;
		this.transactionType = transactionType;
		this.dateOfTransaction = dateOfTransaction;
		this.amount = amount;
		this.account = account;
		this.beneficiary = beneficiary;
	}
	public Beneficiary getBeneficiary() {
		return beneficiary;
	}
	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
	public String getTransactionMode() {
		return transactionMode;
	}
	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public Date getDateOfTransaction() {
		return dateOfTransaction;
	}
	public void setDateOfTransaction(Date dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Transactions(String transactionMode, String transactionType, Date dateOfTransaction, Double amount) {
		super();
		this.transactionMode = transactionMode;
		this.transactionType = transactionType;
		this.dateOfTransaction = dateOfTransaction;
		this.amount = amount;
	}
	public Transactions() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}

