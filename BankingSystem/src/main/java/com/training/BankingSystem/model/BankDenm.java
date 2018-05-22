package com.training.BankingSystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class BankDenm {

	
	private Integer bankId;
	@Id
	private Integer denomination;
	private Integer noOfDenomination;
	/**
	 * @return the bankId
	 */
	public Integer getBankId() {
		return bankId;
	}
	/**
	 * @param bankId the bankId to set
	 */
	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}
	/**
	 * @return the denomination
	 */
	public Integer getDenomination() {
		return denomination;
	}
	/**
	 * @param denomination the denomination to set
	 */
	public void setDenomination(Integer denomination) {
		this.denomination = denomination;
	}
	/**
	 * @return the noOfDenomination
	 */
	public Integer getNoOfDenomination() {
		return noOfDenomination;
	}
	/**
	 * @param noOfDenomination the noOfDenomination to set
	 */
	public void setNoOfDenomination(Integer noOfDenomination) {
		this.noOfDenomination = noOfDenomination;
	}
	public BankDenm(Integer bankId, Integer denomination) {
		super();
		this.bankId = bankId;
		this.denomination = denomination;

	}
	public BankDenm() {
		super();
	}
	
}
