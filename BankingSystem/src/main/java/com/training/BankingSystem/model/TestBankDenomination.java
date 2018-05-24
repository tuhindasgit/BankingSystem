package com.training.BankingSystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class TestBankDenomination extends BaseEntity {


	@Id
	private Integer denomination;
	private Integer noOfDenomination;
	private Integer bankId;
	
	public TestBankDenomination() {
		super();
	}
	public TestBankDenomination(Integer denomination, Integer noOfDenomination, Integer bankId) {
		super();
		this.denomination = denomination;
		this.noOfDenomination = noOfDenomination;
		this.bankId = bankId;
	}
	public Integer getDenomination() {
		return denomination;
	}
	public void setDenomination(Integer denomination) {
		this.denomination = denomination;
	}
	public Integer getNoOfDenomination() {
		return noOfDenomination;
	}
	public void setNoOfDenomination(Integer noOfDenomination) {
		this.noOfDenomination = noOfDenomination;
	}
	public Integer getBankId() {
		return bankId;
	}
	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}
}
