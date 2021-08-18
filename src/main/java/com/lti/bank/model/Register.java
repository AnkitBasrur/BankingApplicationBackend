package com.lti.bank.model;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RegisterLogin")
public class Register {
	@Id
	private String accountNo;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "accountNo")
	AccountDetails accDetails;

	private String userid;
	private String loginpwd;
	private String transactionpwd;

	public Register() {
		super();
	}

	public Register(String accountNo, String userid, String loginpwd, String transactionpwd) {
		super();
		this.accountNo = accountNo;
		this.userid = userid;
		this.loginpwd = loginpwd;
		this.transactionpwd = transactionpwd;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getLoginpwd() {
		return loginpwd;
	}

	public void setLoginpwd(String loginpwd) {
		this.loginpwd = loginpwd;
	}

	public String getTransactionpwd() {
		return transactionpwd;
	}

	public void setTransactionpwd(String transactionpwd) {
		this.transactionpwd = transactionpwd;
	}

	public AccountDetails getAccDetails() {
		return accDetails;
	}

	public void setAccDetails(AccountDetails accDetails) {
		this.accDetails = accDetails;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	@Override
	public String toString() {
		return "Register [accountNo=" + accountNo + ", accDetails=" + accDetails + ", userid=" + userid + ", loginpwd="
				+ loginpwd + ", transactionpwd=" + transactionpwd + "]";
	}

}



