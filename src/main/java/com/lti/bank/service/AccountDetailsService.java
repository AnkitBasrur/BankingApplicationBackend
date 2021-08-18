package com.lti.bank.service;


import java.util.List;

import com.lti.bank.model.AccountDetails;
import com.lti.bank.model.Beneficiary;


public interface AccountDetailsService {
	public AccountDetails findAccountDetails(String accountno);
		
	public boolean addAccountDetails(AccountDetails accountDetails);
	
	public List<AccountDetails> findAccountDetails();


}
