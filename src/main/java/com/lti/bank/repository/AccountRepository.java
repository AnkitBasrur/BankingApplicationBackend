package com.lti.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lti.bank.model.Account;

public interface AccountRepository extends JpaRepository<Account, String>{

}
