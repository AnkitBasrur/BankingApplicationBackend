package com.lti.bank.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Transaction")
public class Transaction {

	private String account_no;
	private int amount;
	private String toAccountNum;
	private String toIfscCode;
	@Id
	private String transactionId;
	private String transactionType;
	private String remarks;
	private String timestamp;
	private String action;

	public String getAccount_no() {
		return account_no;
	}

	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getToAccountNum() {
		return toAccountNum;
	}

	public void setToAccountNum(String toAccountNum) {
		this.toAccountNum = toAccountNum;
	}

	public String getToIfscCode() {
		return toIfscCode;
	}

	public void setToIfscCode(String toIfscCode) {
		this.toIfscCode = toIfscCode;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	@Override
	public String toString() {
		return "Transaction [account_no=" + account_no + ", amount=" + amount + ", toAccountNum=" + toAccountNum
				+ ", toIfscCode=" + toIfscCode + ", transactionId=" + transactionId + ", transactionType="
				+ transactionType + ", remarks=" + remarks + ", timestamp=" + timestamp + ", action=" + action + "]";
	}

	

}
