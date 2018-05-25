package com.training.BankingSystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;
/**
 * @author tuhin
 *
 */
@Entity
public class BankDenomination{


	@Id
	private Integer denomination;
	private Integer noOfDenomination;
	private Integer bankId;
	/**
	 * no parameter constructor
	 */
	public BankDenomination() {
		super();
	}
	/**
	 * 
	 * @param denomination
	 * @param noOfDenomination
	 * @param bankId
	 */
	public BankDenomination(final Integer denomination, final Integer noOfDenomination, final Integer bankId) {
		super();
		this.denomination = denomination;
		this.noOfDenomination = noOfDenomination;
		this.bankId = bankId;
	}
	public Integer getDenomination() {
		return denomination;
	}
	public void setDenomination(final Integer denomination) {
		this.denomination = denomination;
	}
	public Integer getNoOfDenomination() {
		return noOfDenomination;
	}
	public void setNoOfDenomination(final Integer noOfDenomination) {
		this.noOfDenomination = noOfDenomination;
	}
	public Integer getBankId() {
		return bankId;
	}
	public void setBankId(final Integer bankId) {
		this.bankId = bankId;
	}
}
