package com.training.BankingSystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class TestAtmDenominatio extends BaseEntity {


	@Id
	private Integer denomination;
	private Integer noOfDenomination;
	private Integer atmID;
	
	public TestAtmDenominatio() {
		super();
	}
	public TestAtmDenominatio(Integer denomination, Integer noOfDenomination, Integer atmID) {
		super();
		this.denomination = denomination;
		this.noOfDenomination = noOfDenomination;
		this.atmID = atmID;
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
	public Integer getAtmID() {
		return atmID;
	}
	public void setAtmID(Integer atmID) {
		this.atmID = atmID;
	}
}
