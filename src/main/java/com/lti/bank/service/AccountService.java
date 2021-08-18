package com.lti.bank.service;

import java.util.List;

import com.lti.bank.model.Account;

public interface AccountService {
	public List<Account> getAccounts();
	public Account addAccount (Account account);
	public boolean deleteAccount(String oldid);
	public Account findAccount(String oldid);
	public boolean approveAccount(String oldid);
}

