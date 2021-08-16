package com.lti.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.bank.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String>{

}
