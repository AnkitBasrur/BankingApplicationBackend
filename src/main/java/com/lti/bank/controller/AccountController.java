package com.lti.bank.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.bank.model.Account;
import com.lti.bank.service.AccountService;



@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/accountRest/api")
public class AccountController {
	@Autowired
	AccountService accService;
	
	@GetMapping("/accounts")
	public List<Account> getAll(){
		return accService.getAccounts();
	}
	
	
	@GetMapping("/accounts/{oldid}")
	public Account getAccountById(@PathVariable(value="oldid") String oldid) {
		return accService.findAccount(oldid);
		
	}
	
	@PostMapping("/approveAccount")
	public boolean approveAccount(@RequestBody String oldid) {
		return accService.approveAccount(oldid);
	}


	@DeleteMapping("/accounts/{oldid}")
	public boolean deleteAccount(@PathVariable (value="oldid") String oldid) {
		System.out.println(oldid);
		return accService.deleteAccount(oldid);
		
	}

	@PostMapping("/accounts")
	public Account addAccount(@RequestBody Account account) {
		System.out.println(account);
		return accService.addAccount(account);
	}
  }

