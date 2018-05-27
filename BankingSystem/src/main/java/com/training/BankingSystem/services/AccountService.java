package com.training.BankingSystem.services;

import java.math.BigDecimal;

import com.training.BankingSystem.model.Account;
/*
 * Interface that have all the methods related to account Service
 */
public interface AccountService {
	/*
	 * creating account
	 */
	Account createAccount(Account account);

	/*
	 * retrive account details
	 */
	Account getAccountDetails(Integer accountId);

	/*
	 * withdrawing money from atm and bank,inside the implementation there must be
	 * option where we can withdraw money from bank or from atm
	 */
	public void withdrawMoney(BigDecimal withdrawl, Integer accountId, String select, Integer atmId,
			Integer customerId);

	/*
	 * depositing money to bank by customer
	 */
	public Account depositMoney(BigDecimal deposit, Integer accountId);
}
