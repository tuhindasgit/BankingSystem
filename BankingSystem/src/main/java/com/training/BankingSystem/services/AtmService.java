package com.training.BankingSystem.services;

import java.math.BigDecimal;

import com.training.BankingSystem.model.ATM;

public interface AtmService {

	public ATM createBank(ATM atm);
	public ATM addMoneyFromBank(BigDecimal deposit,Integer atmId);
	public ATM withdrawAmmount(BigDecimal withdrawl,Integer atmId,Integer accountId);
}
