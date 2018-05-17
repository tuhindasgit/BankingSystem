package com.training.BankingSystem.services;

import com.training.BankingSystem.model.Account;

public interface AccountService {

	public Account createAccount(Account account);
	public Account getAccountDetails(Integer accountId);
}
