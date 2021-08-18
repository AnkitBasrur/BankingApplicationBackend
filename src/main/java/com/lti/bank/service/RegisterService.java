package com.lti.bank.service;

import java.util.List;

import com.lti.bank.model.Register;

public interface RegisterService {
	public List<Register> getRegisters();
	
	public Register addRegister(Register register);
	
	public Register findRegisterByUserid(String userid, String loginpwd);
	
	public List<Register> updateRegisterByUserid(String userid, String loginpwd);
	public boolean forgotPassword(String account_number, String password);
	public boolean forgotUID(String account_number);
	public boolean changePassword(String accNo, String oldPassword, String newPassword);
}
