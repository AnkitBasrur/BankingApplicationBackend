package com.lti.bank.service;

import java.util.List;
import java.util.Map;

import com.lti.bank.model.Account;
import com.lti.bank.model.AccountDetails;
import com.lti.bank.model.Beneficiary;
import com.lti.bank.model.Transaction;

public interface PaymentService {

	public String requestOTP(String mobile_number, String message);
	public List<Beneficiary> getAllBeneficiaries(String account_no);
	public Map<String, String> pay(Transaction transaction, String transId);
	public Account addAccount(Account account);
	public List<Account> getAccounts();
	public AccountDetails addAccDetails(AccountDetails accDetails);
	public List<AccountDetails> getAccDetails();
	public Beneficiary addBeneficiary(Beneficiary beneficiary);
	public Transaction addTransaction(Transaction transaction);
	public List<Transaction> getAccountStatement(String accountNumber);
	public boolean deleteBeneficiary(String beneficiaryaccno);
}
