package com.lti.bank.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="customer")
public class Customer {

	@Id
	@SequenceGenerator(name="seq",initialValue = 100)
	@GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "seq")
	private long customerId;
	private String title;
	@Column(name="email_id")
	@Email(message = "Enter a Valid Email")
	private String emailId;
	@Column(name="first_name")
	private String firstName;
	@Column(name="middle_name")
	private String middle_name;
	@Column(name="last_name")
	private String lastName;
	@Column(name="father_name")
	private String fatherName;
	@Column(name="aadhar_number")
	private long aadharNumber;
	@Column(name="pancard_number")
	private String pancardNumber;
	@Column(name="residential_address")
	private String residentialAddress;
	@Column(name="permanent_address")
	private String permanentAddress;
	@Column(name="mobile_number")
	private long mobileNumber;
	@Column(name="occupationType")
	private String occupation_type;
	@Column(name="source_of_income")
	private String sourceOfIncome;
	@Column(name="gross_annual_income")
	private int grossAnnualIncome;
	@Column(name="debit_card")
	private int debitCard;
	@Column(name="net_banking")
	private int netBanking;
	
	@Column(name="dob")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dob;
	
	@Column(name="gender")
	private String gender;
	@Column(name="status")
	private int status;
	

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(long customerId, String title, @Email(message = "Enter a Valid Email") String emailId,
			String firstName, String middle_name, String lastName, String fatherName, long aadharNumber,
			String pancardNumber, String residentialAddress, String permanentAddress, long mobileNumber,
			String occupation_type, String sourceOfIncome, int grossAnnualIncome, int debitCard, int netBanking,
			Date dob, String gender, int status) {
		super();
		this.customerId = customerId;
		this.title = title;
		this.emailId = emailId;
		this.firstName = firstName;
		this.middle_name = middle_name;
		this.lastName = lastName;
		this.fatherName = fatherName;
		this.aadharNumber = aadharNumber;
		this.pancardNumber = pancardNumber;
		this.residentialAddress = residentialAddress;
		this.permanentAddress = permanentAddress;
		this.mobileNumber = mobileNumber;
		this.occupation_type = occupation_type;
		this.sourceOfIncome = sourceOfIncome;
		this.grossAnnualIncome = grossAnnualIncome;
		this.debitCard = debitCard;
		this.netBanking = netBanking;
		this.dob = dob;
		this.gender = gender;
		this.status = status;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddle_name() {
		return middle_name;
	}

	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public long getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(long aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getPancardNumber() {
		return pancardNumber;
	}

	public void setPancardNumber(String pancardNumber) {
		this.pancardNumber = pancardNumber;
	}

	public String getResidentialAddress() {
		return residentialAddress;
	}

	public void setResidentialAddress(String residentialAddress) {
		this.residentialAddress = residentialAddress;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getOccupation_type() {
		return occupation_type;
	}

	public void setOccupation_type(String occupation_type) {
		this.occupation_type = occupation_type;
	}

	public String getSourceOfIncome() {
		return sourceOfIncome;
	}

	public void setSourceOfIncome(String sourceOfIncome) {
		this.sourceOfIncome = sourceOfIncome;
	}

	public int getGrossAnnualIncome() {
		return grossAnnualIncome;
	}

	public void setGrossAnnualIncome(int grossAnnualIncome) {
		this.grossAnnualIncome = grossAnnualIncome;
	}

	public int getDebitCard() {
		return debitCard;
	}

	public void setDebitCard(int debitCard) {
		this.debitCard = debitCard;
	}

	public int getNetBanking() {
		return netBanking;
	}

	public void setNetBanking(int netBanking) {
		this.netBanking = netBanking;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
