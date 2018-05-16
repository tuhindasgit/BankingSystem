package com.training.BankingSystem.services;

import org.springframework.http.ResponseEntity;

import com.training.BankingSystem.model.Bank;

public interface BankService {

	public Bank createBank(Bank bank);
	public Bank getBankDetails(Integer bankId);
	
}
