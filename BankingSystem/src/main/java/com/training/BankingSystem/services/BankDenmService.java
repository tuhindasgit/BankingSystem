package com.training.BankingSystem.services;

import java.math.BigDecimal;
import java.util.List;

/**
 * 
 * @author tuhin
 *
 */
public interface BankDenmService {

	/**
	 * will calculate the no of denomination will be added when 
	 * we made some deposit in bank
	 * @param amount
	 * @param bankId
	 */
	void deptDenmInBank(BigDecimal amount,Integer bankId);
	/**
	 * will calculate the no of denomination will be
	 * taken/withdrawn when we made withdraw from bank
	 * @param amount
	 * @param bankId
	 */
	void wdlDenmFrmBank(BigDecimal amount,Integer bankId);

	/**
	 * creating bank Denomination
	 * @param denomination
	 * @param bankId
	 */
	void createBankDenomination(List<Integer> denomination, Integer bankId);
	
}
