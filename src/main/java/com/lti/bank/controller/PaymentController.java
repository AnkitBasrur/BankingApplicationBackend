package com.lti.bank.controller;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.bank.model.Account;
import com.lti.bank.model.AccountDetails;
import com.lti.bank.model.Beneficiary;
import com.lti.bank.model.Transaction;
import com.lti.bank.service.PaymentService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/payment/api")
public class PaymentController {

	@Autowired
	PaymentService paymentService;

	@GetMapping("/beneficiaries/{acc_num}")
	public List<Beneficiary> getAll(@PathVariable(value = "acc_num") String acc_num) {
		return paymentService.getAllBeneficiaries(acc_num);
	}

	@GetMapping("/requestOTP/{acc_num}")
	public String requestOTP(@PathVariable(value = "acc_num") String acc_num) {
		return paymentService.requestOTP(acc_num);
	}

	@PostMapping("/pay/{transId}")
	public Map<String, String> pay(@RequestBody Transaction transaction, @PathVariable(value = "transId") String transId) {
		return paymentService.pay(transaction, transId);
	}

	@DeleteMapping("/deleteBeneficiaries/{beneficiaryaccno}")
	public boolean deleteBeneficiary(@PathVariable(value = "beneficiaryaccno") String beneficiaryaccno) {
		return paymentService.deleteBeneficiary(beneficiaryaccno);
	}

	@PostMapping("/addAccount")
	public Account addAccount(@RequestBody Account account) {
		return paymentService.addAccount(account);
	}

	@GetMapping("/getAcc")
	public List<Account> getAcc() {
		return paymentService.getAccounts();
	}

	@PostMapping("/addAccDetails")
	public AccountDetails addAccDetails(@RequestBody AccountDetails accDetails) {
		return paymentService.addAccDetails(accDetails);
	}

	@GetMapping("/getAccDetails")
	public List<AccountDetails> getAccDetails() {
		return paymentService.getAccDetails();
	}

	@PostMapping("/addBeneficiary")
	public Beneficiary addBeneficiary(@RequestBody Beneficiary beneficiary) {
		return paymentService.addBeneficiary(beneficiary);
	}

	@PostMapping("/addTransaction")
	public Transaction addTransaction(@RequestBody Transaction transaction) {
		return paymentService.addTransaction(transaction);
	}

	@GetMapping("/getAccountStatement/{accountNumber}")
	public List<Transaction> getAccountStatement(@PathVariable(value = "accountNumber") String accountNumber) {
		return paymentService.getAccountStatement(accountNumber);
	}

}
