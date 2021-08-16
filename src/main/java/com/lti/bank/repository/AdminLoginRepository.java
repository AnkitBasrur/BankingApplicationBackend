package com.lti.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lti.bank.model.AdminLogin;

@Repository
public interface AdminLoginRepository extends JpaRepository<AdminLogin, String > {
	
	@Query("from AdminLogin a where a.adminId LIKE ?1 AND a.adminPwd LIKE ?2")
	public AdminLogin findByAdminId(String adminId, String adminPwd);
	
	@Query("from AdminLogin a where a.adminId LIKE ?1 AND a.adminPwd LIKE ?2")
	public List<AdminLogin> updateByAdminId(String adminId, String adminPwd);
	

}

