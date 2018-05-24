package com.training.BankingSystem.services;

import com.training.bankingsystem.model.Bank;

public interface BankService {

	/*
	 * creating new bank
	 */
	 Bank createBank(Bank bank);
	 /*
	  * Retrieve a specific bank
	  */
	 Bank getBankDetails(Integer bankId);
	 }
