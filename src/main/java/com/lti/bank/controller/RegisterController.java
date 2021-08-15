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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.bank.model.AccountDetails;
import com.lti.bank.model.Register;
import com.lti.bank.service.RegisterService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("registerRest/api")
public class RegisterController {
	@Autowired
	RegisterService regService;
	
	@PutMapping("/forgotPassword/{acc_num}/{password}")
	public boolean forgotPassword(@PathVariable(value="acc_num") String acc_num, @PathVariable(value="password") String password) {
		return regService.forgotPassword(acc_num, password);
	}
	
	@PutMapping("/forgotUID/{acc_num}")
	public boolean forgotUID(@PathVariable(value="acc_num") String acc_num) {
		return regService.forgotUID(acc_num);
	}
	
	@GetMapping("/register")
	public List<Register> getAll(){
		return regService.getRegisters();
	}
	
	@PostMapping("/register") 
	public Register addRegister(@RequestBody Register register) {
		return regService.addRegister(register);
	}
	
	@GetMapping("/login/{userid}/{loginpwd}")
	public Register getRegisterByUserid(@PathVariable(value="userid")String userid, @PathVariable(value="loginpwd")String loginpwd){
		return regService.findRegisterByUserid(userid, loginpwd);
	}
	
	@PutMapping("/login/{userid}/{loginpwd}")
	public List<Register> updateRegisterByUserid(@PathVariable(value="userid")String userid, @PathVariable(value="loginpwd")String loginpwd){
		return regService.updateRegisterByUserid(userid, loginpwd);
	}
	
	@GetMapping("/changePassword/{userId}/{oldPassword}/{newPassword}")
	public boolean changePassword(@PathVariable(value="userId")String userId, @PathVariable(value="oldPassword")String oldPassword, @PathVariable(value="newPassword")String newPassword) {
		System.out.println(userId+" "+oldPassword+" "+newPassword);
		return regService.changePassword(userId, oldPassword, newPassword);
	}

}


