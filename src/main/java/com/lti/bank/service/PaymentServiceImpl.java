package com.lti.bank.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.bank.exceptions.AccountDoesNotExistException;
import com.lti.bank.exceptions.IncorrectAmountException;
import com.lti.bank.helpers.OTP;
import com.lti.bank.model.Account;
import com.lti.bank.model.AccountDetails;
import com.lti.bank.model.Beneficiary;
import com.lti.bank.model.Register;
import com.lti.bank.model.Transaction;
import com.lti.bank.repository.AccountDetailsRepository;
import com.lti.bank.repository.AccountRepository;
import com.lti.bank.repository.BeneficiaryRepository;
import com.lti.bank.repository.TransactionRepository;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	BeneficiaryRepository benRepo;
	@Autowired
	AccountDetailsRepository accDetailsRepo;
	@Autowired
	TransactionRepository transRepo;
	@Autowired
	AccountRepository accRepo;

	public String generateOTP() {
		Random rand = new Random();
		System.out.println("Random numbers...");
		int resRandom = rand.nextInt((999999 - 10000) + 1) + 10;
		String otp = resRandom + "";
		return otp;
	}

	@Override
	public String requestOTP(String account_number, String message) {

		String otp = generateOTP();

		AccountDetails accDetails = getAccountDetails(account_number);
		String emailId = accDetails.getAccountoldid().getUserEmailid();
		String userName = accDetails.getAccountoldid().getUserFirstname();

		OTP otpHelper = new OTP();
		otpHelper.requestOTP(emailId, message,
				"Dear " + userName + "," + "\n\nHere's your OTP: " + otp);

		return otp;
	}

	@Override
	public List<Beneficiary> getAllBeneficiaries(String account_no) {
		return benRepo.findByAccountNo(account_no);
	}

	@Override
	public Map<String, String> pay(Transaction transaction, String transId) {
		Map<String, String> result = new HashMap<>();
		System.out.println(transaction);
		System.out.println(transId);

		if (transaction.getAmount() < 0) {
			try {
				throw new IncorrectAmountException("Amount cannot be negative");
			} catch (Exception e) {
				result.put("status", "Transaction Failed");
				result.put("message", "Amount cannot be negative");
				return result;
			}
		}
		AccountDetails sender = getAccountDetails(transaction.getAccount_no());
		AccountDetails receiver = getAccountDetails(transaction.getToAccountNum());

		if (receiver == null) {
			try {
				throw new AccountDoesNotExistException("Account Does not Exist");
			} catch (Exception e) {
				result.put("status", "Transaction Failed");
				result.put("message", "Account Does not Exist");
				return result;
			}
		}

		if (transaction.getAmount() > sender.getAccountBalance()) {
			try {
				throw new IncorrectAmountException("Insufficient Funds");
			} catch (Exception e) {
				result.put("status", "Transaction Failed");
				result.put("message", "Insufficient Funds");
				return result;
			}
		}
		List<Transaction> transactions = sender.getTransactions();
		transactions.add(transaction);
		sender.setAccountBalance(sender.getAccountBalance() - transaction.getAmount());
		receiver.setAccountBalance(receiver.getAccountBalance() + transaction.getAmount());

		accDetailsRepo.save(sender);
		transRepo.save(transaction);

		transaction.setTransactionId(transId);
		transaction.setAction("Credit");
		String toAcc = transaction.getToAccountNum();
		transaction.setToAccountNum(transaction.getAccount_no());
		transaction.setAccount_no(toAcc);
		List<Transaction> receiverTransactions = receiver.getTransactions();
		receiverTransactions.add(transaction);
		accDetailsRepo.save(receiver);

		result.put("message", "Transaction Successful!");
		return result;
	}

	public AccountDetails getAccountDetails(String account_no) {
		try {
			return accDetailsRepo.findById(account_no).get();
		} catch (Exception e) {
			System.out.println("exception" + e.getMessage());
		}
		return null;
	}

	public Account addAccount(Account account) {
		return accRepo.save(account);
	}

	public List<Account> getAccounts() {
		return accRepo.findAll();
	}

	@Override
	public AccountDetails addAccDetails(AccountDetails accDetails) {
		return accDetailsRepo.save(accDetails);
	}

	@Override
	public List<AccountDetails> getAccDetails() {
		return accDetailsRepo.findAll();
	}

	@Override
	public Beneficiary addBeneficiary(Beneficiary beneficiary) {
		try {
			AccountDetails account = getAccountDetails(beneficiary.getBeneficiaryaccno());
			AccountDetails accDetails = getAccountDetails(beneficiary.getAccountNo());
			if (account == null || accDetails == null)
				return null;
			List<Beneficiary> beneficiaries = accDetails.getBeneficiaries();
			beneficiaries.add(beneficiary);
			accDetailsRepo.save(accDetails);
			benRepo.save(beneficiary);
			return beneficiary;
		} catch (Exception e) {
			System.out.println("caught");
			return null;
		}
	}

	@Override
	public Transaction addTransaction(Transaction transaction) {
		AccountDetails accDetails = getAccountDetails(transaction.getAccount_no());
		List<Transaction> transactions = accDetails.getTransactions();
		transactions.add(transaction);
		accDetailsRepo.save(accDetails);
		transRepo.save(transaction);
		return transaction;
	}

	@Override
	public List<Transaction> getAccountStatement(String accountNumber) {
		AccountDetails accDetails = getAccountDetails(accountNumber);
		return accDetails.getTransactions();
	}
	
	@Override
	public boolean deleteBeneficiary(String beneficiaryId) {
		benRepo.deleteById(beneficiaryId);
		return true;
	}
}
