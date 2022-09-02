package com.lti.bank.model;

import javax.persistence.*;

@Entity
@Table(name="beneficiary")
public class Beneficiary {
	
	@Id
	@SequenceGenerator(name="seq",initialValue = 100)
	@GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "seq")
	Long beneficiaryId;
	
	@Column(name="beneficiary_name")
	String beneficiaryName;
	@Column(name="beneficiary_account_no")
	Long beneficiaryAccountNo;
	
	@Column(name="nickname")
	String nickname;
	
	@ManyToOne
	Account account;
	
	
	
	public Beneficiary(Long beneficiaryId, String beneficiaryName, Long beneficiaryAccountNo, String nickname,
			Account account) {
		super();
		this.beneficiaryId = beneficiaryId;
		this.beneficiaryName = beneficiaryName;
		this.beneficiaryAccountNo = beneficiaryAccountNo;
		this.nickname = nickname;
		this.account = account;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}

	public Long getBeneficiaryAccountNo() {
		return beneficiaryAccountNo;
	}

	public void setBeneficiaryAccountNo(Long beneficiaryAccountNo) {
		this.beneficiaryAccountNo = beneficiaryAccountNo;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Beneficiary(Long beneficiaryId, String beneficiaryName, Long beneficiaryAccountNo, String nickname) {
		super();
		this.beneficiaryId = beneficiaryId;
		this.beneficiaryName = beneficiaryName;
		this.beneficiaryAccountNo = beneficiaryAccountNo;
		this.nickname = nickname;
	}

	public Beneficiary() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Beneficiary [beneficiaryId=" + beneficiaryId + ", beneficiaryName=" + beneficiaryName
				+ ", beneficiaryAccountNo=" + beneficiaryAccountNo + ", nickname=" + nickname + ", account=" + account
				+ "]";
	}
	
	
	
	

}
