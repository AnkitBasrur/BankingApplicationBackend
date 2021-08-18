package com.lti.bank.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.bank.model.AdminLogin;
import com.lti.bank.repository.AdminLoginRepository;

@Service
@Transactional
public class AdminLoginServiceImpl implements AdminLoginService {
	
	@Autowired
	AdminLoginRepository adRepo;

	@Override
	public boolean findAdminLoginByAdminId(String adminId, String loginPwd) {		
		try {
			AdminLogin admin = adRepo.findByAdminId(adminId, loginPwd);
			if(admin==null)
				return false;
		}
		catch(Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public List<AdminLogin> updateAdminLoginByAdminId(String adminId, String loginPwd) {
		return adRepo.updateByAdminId(adminId, loginPwd);
	}

}




