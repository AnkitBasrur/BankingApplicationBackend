package com.lti.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lti.bank.model.AccountDetails;

public interface AccountDetailsRepository extends JpaRepository<AccountDetails, String>{

}
