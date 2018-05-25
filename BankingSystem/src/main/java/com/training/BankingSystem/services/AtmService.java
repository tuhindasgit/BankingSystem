package com.training.BankingSystem.services;

import java.math.BigDecimal;

import com.training.BankingSystem.model.ATM;

/**
 * @author tuhin
 *
 */
public interface AtmService {

	/**
	 * 
	 * @param atm
	 * @return created atm
	 */
	ATM createBank(ATM atm);
	/**
	 * 
	 * @param deposit
	 * @param atmId
	 * @return atm where money added
	 */
 	ATM addMoneyFromBank(BigDecimal deposit,Integer atmId);
}
