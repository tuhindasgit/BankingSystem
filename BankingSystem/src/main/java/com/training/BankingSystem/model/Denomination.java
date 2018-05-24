package com.training.BankingSystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.training.BankingSystem.helper.BaseEntity;

/**
 * @author tuhin
 *
 */
@Entity
public class Denomination extends BaseEntity{

	@Id
	private Integer denomination;
	/**
	 * 
	 * @param denomination
	 */
	public Denomination(final Integer denomination) {
		super();
		this.denomination = denomination;
	}

	public Integer getDenomination() {
		return denomination;
	}

	public void setDenomination(final Integer denomination) {
		this.denomination = denomination;
	}
/**
 * no parameter constructor
 */
	public Denomination() {
		super();
	}
	
	
}
