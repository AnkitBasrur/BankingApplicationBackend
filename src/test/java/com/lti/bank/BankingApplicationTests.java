package com.lti.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lti.bank.model.Account;
import com.lti.bank.model.AdminLogin;
import com.lti.bank.model.Register;
import com.lti.bank.model.Transaction;
import com.lti.bank.repository.AccountRepository;
import com.lti.bank.repository.TransactionRepository;
import com.lti.bank.service.AccountService;
import com.lti.bank.service.AdminLoginService;

@SpringBootTest
class BankingApplicationTests {

	@Autowired
	TransactionRepository transRepo;
	
	@Autowired
	AccountService accService;
	
	@Autowired
	AccountRepository accRepo;
	
	
	@Test
	public void testCreate() {
		Transaction trans = new Transaction();
		trans.setAccount_no("1");
		trans.setAction("Credit");
		trans.setAmount(1000);
		trans.setRemarks("Grocery");
		trans.setTimestamp("16/08/2021");
		trans.setToAccountNum("2");
		trans.setToIfscCode("101");
		trans.setTransactionId("201");
		trans.setTransactionType("RTGS");
		transRepo.save(trans);
		assertNotNull(transRepo.findById("201"));
	}	
	
	@Test
	void testFindAccount(){
		Account acc= accService.findAccount("617038");
		accRepo.save(acc);
		assertNotNull(accRepo.findById("617038"));
		}
	
	@Test
	void testAddAccount() {
		Account acc= new Account();
		acc.setCounter(0);
		acc.setOldid("123456");
		acc.setUserAadharcard("233376009302");
		acc.setUserDob("08/01/2000");
		acc.setUserEmailid("ayushiagrawal.201@gmail.com");
		acc.setUserFathername("Abc");
		acc.setUserFirstname("Chandni");
		acc.setUserGrossannualincome("40000");
		acc.setUserIslocked(false);
		acc.setUserIsverified(true);
		acc.setUserLastname("Agr");
		acc.setUserMiddlename("A");
		acc.setUserMobileno("8839835241");
		acc.setUserOccupationType("Service");
		acc.setUserPermanentaddr("Gwalior");
		acc.setUserResidentialaddr("Gwl");
		acc.setUserTitle("Ms");
		accService.addAccount(acc);
		assertNotNull(accService.findAccount("123456"));
	}
	
	
		

}





