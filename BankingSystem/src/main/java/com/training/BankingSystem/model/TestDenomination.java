package com.training.BankingSystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TestDenomination {

	@Id
	private Integer denomination;

	public TestDenomination(Integer denomination) {
		super();
		this.denomination = denomination;
	}

	public Integer getDenomination() {
		return denomination;
	}

	public void setDenomination(Integer denomination) {
		this.denomination = denomination;
	}

	public TestDenomination() {
		super();
	}
	
	
}
