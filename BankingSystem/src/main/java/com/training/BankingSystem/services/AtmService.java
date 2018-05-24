package com.training.BankingSystem.services;

import java.math.BigDecimal;

import com.training.bankingsystem.model.ATM;

public interface AtmService {

	public ATM createBank(ATM atm);
	public ATM addMoneyFromBank(BigDecimal deposit,Integer atmId);
}
