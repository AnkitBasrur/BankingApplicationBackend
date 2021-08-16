package com.lti.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.bank.model.AccountDetails;
import com.lti.bank.model.Register;
import com.lti.bank.repository.RegisterRepository;

@Service
@Transactional
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	RegisterRepository regRepo;
	@Autowired
	AccountDetailsService accDetails;

	@Override
	public List<Register> getRegisters() {
		return regRepo.findAll();
	}

	@Override
	public Register addRegister(Register register) {
		try {
			AccountDetails account = accDetails.findAccountDetails(register.getAccountNo());
			register.setAccDetails(account);
			return regRepo.save(register);
		} catch (Exception e) {
			System.out.println("caught up");
			return null;
		}
	}

	@Override
	public Register findRegisterByUserid(String userid, String loginpwd) {
		Register reg = regRepo.findByUserid(userid, loginpwd);
		System.out.println(reg);
		return reg;
	}

	@Override
	public List<Register> updateRegisterByUserid(String userid, String loginpwd) {
		return regRepo.updateByUserid(userid, loginpwd);
	}

//	@Override
//	public boolean checkLogin(String userid, String loginpwd) {
//		if()
//		return false;
//	}

	@Override
	public boolean forgotPassword(String account_number, String password) {
		System.out.println(account_number + " " + password);
		Register reg = regRepo.getById(account_number);
		System.out.println(reg);
		reg.setLoginpwd(password);
		regRepo.save(reg);
		return true;
	}

	@Override
	public boolean forgotUID(String account_number) {

		return true;
	}

	@Override
	public boolean changePassword(String accNo, String oldPassword, String newPassword) {
		Register reg = regRepo.getById(accNo);
		if (reg == null)
			return false;
		if (reg.getLoginpwd().equals(oldPassword)) {
			reg.setLoginpwd(newPassword);
			regRepo.save(reg);
			return true;
		} else
			return false;
	}

}
