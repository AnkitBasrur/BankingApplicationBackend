package com.lti.bank.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="AccountDetails")
public class AccountDetails {
	
	@Id
	private String accountNo;
	private String userid;
	private String accountType;
	private int accountBalance;
	private String userIfscCode;
	private String oldid;
	
	@NotNull
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="oldid", insertable=false, updatable= false)
	private Account accountoldid;
	
	@OneToMany(targetEntity = Transaction.class, cascade = CascadeType.ALL)
	@JoinColumn(name="acc_trans", referencedColumnName = "accountNo")
	private List<Transaction> transactions;
	
	@OneToMany(targetEntity = Beneficiary.class, cascade = CascadeType.ALL)
	@JoinColumn(name="acc_benef", referencedColumnName = "accountNo")
	private List<Beneficiary> beneficiaries;
	
	public AccountDetails() {
		super();
	}

	public AccountDetails(String accountNo, String userid, String accountType, int accountBalance, String userIfscCode, String oldid) {
		super();
		this.accountNo = accountNo;
		this.userid = userid;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.userIfscCode = userIfscCode;
		this.oldid = oldid;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public int getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getUserIfscCode() {
		return userIfscCode;
	}

	public void setUserIfscCode(String userIfscCode) {
		this.userIfscCode = userIfscCode;
	}

	public String getOldid() {
		return oldid;
	}

	public void setOldid(String oldid) {
		this.oldid = oldid;
	}

	public Account getAccountoldid() {
		return accountoldid;
	}

	public void setAccountoldid(Account accountoldid) {
		this.accountoldid = accountoldid;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public List<Beneficiary> getBeneficiaries() {
		return beneficiaries;
	}

	public void setBeneficiaries(List<Beneficiary> beneficiaries) {
		this.beneficiaries = beneficiaries;
	}

	@Override
	public String toString() {
		return "AccountDetails [accountNo=" + accountNo + ", userid=" + userid + ", accountType=" + accountType
				+ ", accountBalance=" + accountBalance + ", userIfscCode=" + userIfscCode + ", oldid=" + oldid
				+ ", accountoldid=" + accountoldid + ", transactions=" + transactions + ", beneficiaries="
				+ beneficiaries + "]";
	}

	
}