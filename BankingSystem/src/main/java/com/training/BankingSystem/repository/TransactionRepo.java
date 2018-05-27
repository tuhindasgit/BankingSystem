package com.training.BankingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.BankingSystem.model.Transaction;
/**
 * 
 * @author tuhin
 *
 */
public interface TransactionRepo extends JpaRepository<Transaction, Integer> {

}
