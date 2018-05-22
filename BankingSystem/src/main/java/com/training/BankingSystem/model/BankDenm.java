package com.training.BankingSystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class BankDenm {

	
	private Integer bankId;
	@Id
	private Integer denomination;
	private Integer noOfDenomination;
	public BankDenm(Integer bankId, Integer denomination, Integer noOfDenomination) {
		super();
		this.bankId = bankId;
		this.denomination = denomination;
		this.noOfDenomination = noOfDenomination;
	}
	public BankDenm() {
		super();
	}
	
}
