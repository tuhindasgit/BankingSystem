package com.training.BankingSystem.services;

import java.util.List;

import com.training.BankingSystem.model.Denomination;

/**
 * @author tuhin
 *
 */
public interface DenmService {

	/**
	 * adding denomination
	 * @param denomination
	 */
	void addDenomination(List<Integer> denomination);
	/**
	 * retrive the list of denomination
	 * @return
	 */
	List<Denomination> denominationList();
}
