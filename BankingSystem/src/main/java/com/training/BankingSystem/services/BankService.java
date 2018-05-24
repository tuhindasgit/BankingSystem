package com.training.BankingSystem.services;

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
	 }
