package com.lti.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.bank.model.AdminLogin;
import com.lti.bank.service.AdminLoginService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("adminRest/api")
public class AdminLoginController {

	@Autowired
	AdminLoginService adService;

	@GetMapping("/admin/{adminId}/{adminPwd}")
	public boolean getAdminLoginByAdminId(@PathVariable(value = "adminId") String adminId, @PathVariable(value = "adminPwd") String adminPwd) {
		return adService.findAdminLoginByAdminId(adminId, adminPwd);
	}

	@PutMapping("/admin/{adminId}/{adminPwd}")
	public List<AdminLogin> updateAdminLoginByAdminId(@PathVariable(value = "adminId") String adminId, @PathVariable(value = "adminPwd") String adminPwd) {
		return adService.updateAdminLoginByAdminId(adminId, adminPwd);
	}
}
