package com.lti.bank.service;

import java.util.List;

import com.lti.bank.model.AdminLogin;

public interface AdminLoginService {
	
	public boolean findAdminLoginByAdminId(String adminId, String loginPwd);

	public List<AdminLogin> updateAdminLoginByAdminId(String adminId, String loginPwd);
}
