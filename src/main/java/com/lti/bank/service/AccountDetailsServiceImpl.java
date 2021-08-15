package com.lti.bank.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.bank.model.AccountDetails;
import com.lti.bank.model.Beneficiary;
import com.lti.bank.repository.AccountDetailsRepository;
import com.lti.bank.repository.BeneficiaryRepository;

@Service
@Transactional
public class AccountDetailsServiceImpl implements AccountDetailsService {

	@Autowired
	AccountDetailsRepository accRepo;

	@Override
	public AccountDetails findAccountDetails(String accountno) {
		System.out.println(accountno);
		return accRepo.findById(accountno).get();
	}

	@Override
	public boolean addAccountDetails(AccountDetails accountDetails) {

		accRepo.save(accountDetails);
		return true;
	}

	@Override
	public List<AccountDetails> findAccountDetails() {

		return accRepo.findAll();
	}

//	@Override
//	public AccountDetails updateAccountDetailsByOldid(AccountDetails accountDetails) {
//		System.out.println("hello");
//		AccountDetails updAccD= accRepo.findByAccountoldid(accountDetails.getAccountoldid().getOldid());
//		System.out.println(updAccD.getUserid());
//		updAccD.setAccountoldid(accountDetails.getAccountoldid());
//		updAccD= accountDetails;
//		return accRepo.save(updAccD);
//	}

}
