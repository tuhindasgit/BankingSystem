package com.training.BankingSystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class RefAtmDenm {
	
	private Integer atmID;
	@Id
	private Integer denomination;
	private Integer noOfDenomination;
	
}
