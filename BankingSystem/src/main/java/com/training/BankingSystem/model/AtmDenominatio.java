package com.training.BankingSystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.training.BankingSystem.helper.BaseEntity;
/**
 * @author tuhin
 *
 */
@Entity
public class AtmDenominatio extends BaseEntity {
	@Id
	private Integer denomination;
	private Integer noOfDenomination;
	private Integer atmID;
	/**
	 * no-parameter constructor
	 */
	public AtmDenominatio() {
		super();
	}
	/**
	 * 
	 * @param denomination
	 * @param noOfDenomination
	 * @param atmID
	 */
	public AtmDenominatio(final Integer denomination,final Integer noOfDenomination,final Integer atmID) {
		super();
		this.denomination = denomination;
		this.noOfDenomination = noOfDenomination;
		this.atmID = atmID;
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
	public Integer getAtmID() {
		return atmID;
	}
	public void setAtmID(final Integer atmID) {
		this.atmID = atmID;
	}
}
