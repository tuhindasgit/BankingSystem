package com.training.BankingSystem.services;

import java.math.BigDecimal;

import com.training.BankingSystem.model.BankDenm;

public interface BankDenmService {

	void depositDemn(BigDecimal ammount, Integer bankId);
	void withdrawDenm(BigDecimal ammount, Integer bankId);
	void createBankDenm(BankDenm bankDenm);
}
