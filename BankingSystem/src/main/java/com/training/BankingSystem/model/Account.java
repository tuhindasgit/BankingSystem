package com.training.BankingSystem.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Entity
@Data
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer accountId;
	public Account(Integer accountId, Integer customerId, Integer bankId, BigDecimal ammount) {
		super();
		this.accountId = accountId;
		this.customerId = customerId;
		this.bankId = bankId;
		this.ammount = ammount;
	}
	public Account() {
		super();
	}
	private Integer customerId;
	private Integer bankId;
	private BigDecimal ammount;
}
