package com.lti.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.lti.bank.model.Register;

@Repository
public interface RegisterRepository extends JpaRepository<Register, String>{

	@Query("from Register r where r.userid LIKE ?1 AND r.loginpwd LIKE ?2")
	public Register findByUserid(String userid, String loginpwd);
	
	@Query("from Register r where r.userid LIKE ?1 AND r.loginpwd LIKE ?2")
	public List<Register> updateByUserid(String userid, String loginpwd);
	

}
