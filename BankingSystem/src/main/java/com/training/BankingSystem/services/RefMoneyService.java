package com.training.BankingSystem.services;

import java.util.List;

import com.training.BankingSystem.model.RefMoney;

public interface RefMoneyService {
	void addDenomination(Integer deno1);
	List<RefMoney> listOfDenomination();
}