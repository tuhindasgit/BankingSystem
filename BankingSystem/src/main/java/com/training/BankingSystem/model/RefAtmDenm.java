package com.training.BankingSystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class RefAtmDenm {
	
	private Integer atmID;
	@Id
	private Integer denomination;
	private Integer noOfDenomination;
	/**
	 * @return the atmID
	 */
	public Integer getAtmID() {
		return atmID;
	}
	/**
	 * @param atmID the atmID to set
	 */
	public void setAtmID(Integer atmID) {
		this.atmID = atmID;
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
	public RefAtmDenm(Integer atmID, Integer denomination) {
		super();
		this.atmID = atmID;
		this.denomination = denomination;

	}
	public RefAtmDenm() {
		super();
	}
	
}
