package com.training.BankingSystem.services;

import java.util.Optional;

import com.training.BankingSystem.model.Bank;

public interface BankService {

	/**
	 * creating new bank
	 */
	 Bank createBank(Bank bank);
	 /**
	  * Retrieve a specific bank
	  */
	 Bank getBankDetails(Integer bankId);
	 /**
	  * validating customer object is present or not
	  */
	 Optional<Bank> findById(Integer bankId);
	 }
