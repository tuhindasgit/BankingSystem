package com.training.BankingSystem.services;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;

import com.training.BankingSystem.model.Account;

public interface AccountService {

 

	public Account createAccount(Account account);
	public Account getAccountDetails(Integer accountId);
	public void withdrawMoney(BigDecimal withdrawl,Integer accountId,String select,Integer atmId,Integer customerId);
	public Account depositMoney(BigDecimal deposit,Integer accountId);
}
