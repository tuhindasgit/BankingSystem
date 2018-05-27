package com.training.BankingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.BankingSystem.model.Account;
/**
 * 
 * @author tuhin
 *
 */
public interface AccountRepo extends JpaRepository<Account, Integer> {

	
}
