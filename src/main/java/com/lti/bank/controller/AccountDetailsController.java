package com.lti.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.bank.model.AccountDetails;
import com.lti.bank.model.Beneficiary;
import com.lti.bank.model.Register;
import com.lti.bank.service.AccountDetailsService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/accountdetailsRest/api")
public class AccountDetailsController {
	
	@Autowired
	AccountDetailsService accService;
	
	@GetMapping("/accountdetails")
	public List<AccountDetails> getAccountDetails() {
		return accService.findAccountDetails();
	}
	
	@GetMapping("/accountdetails/{accountno}")
	public AccountDetails getAccountDetailsById(@PathVariable(value="accountno")String accountno) {
		return accService.findAccountDetails(accountno);
	}
	
	@PostMapping("/accountdetails")
	public boolean addAccountDetails(@RequestBody AccountDetails accountDetails) {
		return accService.addAccountDetails(accountDetails);
	}

}


