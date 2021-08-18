package com.lti.bank.service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.bank.helpers.OTP;
import com.lti.bank.model.Account;
import com.lti.bank.model.AccountDetails;
import com.lti.bank.repository.AccountRepository;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accRepo;
	@Autowired
	AccountDetailsService accDetails;
	
	@Override
	public List<Account> getAccounts() {
		List<Account> result = new ArrayList<>();
		List<Account> accounts = accRepo.findAll();

		for (Account account : accounts) {
			if (!account.isUserIsverified()) {
				result.add(account);
			}
		}
		return result;
	}

	@Override
	public Account addAccount(Account account) {
		accRepo.save(account);
		return account;
	}


	@Override
	public Account findAccount(String oldid) {
		return accRepo.getById(oldid);
	}


	@Override
	public boolean deleteAccount(String oldid) {
		accRepo.deleteById(oldid);
		return true;
	}

	@Override
	public boolean approveAccount(String oldid) {
		Account account = findAccount(oldid);
		System.out.println(account);
		String toEmail = account.getUserEmailid();
		String subject = "Congratulations!! Your Account has been Approved";
		String message = "";
		String accountNo = generateAccountNo(9);
		String userid = generateAccountNo(6);
		String ifsc = generateIfsc();

		message = "Please note your Account Details given below: \nAccount Number: "+accountNo+"\nUser ID: "+userid+"\nIFSC: "+ifsc;
		OTP otpHelper = new OTP();
		otpHelper.requestOTP(toEmail, subject, message);
		account.setUserIsverified(true);
		accRepo.save(account);
		AccountDetails acc = new AccountDetails(accountNo, userid, "Savings", 0, ifsc, account.getOldid());
		accDetails.addAccountDetails(acc);
		return true;
	}

	public String generateAccountNo(int len) {
		String start = "";
		Random value = new Random();
		start = (value.nextInt(10)+1)+"";
		int n = 0;
		for (int i = 0; i < len-1; i++) {
			n = value.nextInt(10);
			start += Integer.toString(n);
		}

		return start;
	}

	public String generateIfsc() {
		String start = "HDFC";
		Random value = new Random();

		int r1 = value.nextInt(10);
		int r2 = value.nextInt(10);
		start += Integer.toString(r1) + Integer.toString(r2);

		int n = 0;
		for (int i = 0; i < 9; i++) {
			n = value.nextInt(10);
			start += Integer.toString(n);
		}

		return start;
	}

}
