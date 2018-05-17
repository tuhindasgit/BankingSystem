package com.training.BankingSystem.services;

import java.math.BigDecimal;

import com.training.BankingSystem.model.Account;

public interface AccountService {

	public Account createAccount(Account account);
	public Account getAccountDetails(Integer accountId);
	public Account withdrawMoney(BigDecimal withdrawl,Integer accountId);
	public Account depositMoney(BigDecimal deposit,Integer accountId);
}
