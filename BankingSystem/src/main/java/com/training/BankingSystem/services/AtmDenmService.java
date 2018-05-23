package com.training.BankingSystem.services;

import java.math.BigDecimal;

import com.training.BankingSystem.model.BankDenm;
import com.training.BankingSystem.model.RefAtmDenm;

public interface AtmDenmService {

	void CreateAtmDenm(RefAtmDenm refAtmDenm);
	void depositFromBankDenm(BigDecimal ammount, Integer atmId);
	void withdrawDenm(BigDecimal ammount, Integer atmId);
}
