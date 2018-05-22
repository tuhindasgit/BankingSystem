package com.training.BankingSystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class RefMoney {
	@Id
	private Integer denomination;
}
