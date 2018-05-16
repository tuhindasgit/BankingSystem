package com.training.BankingSystem.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Entity
@Data
public class Transaction {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer transactionId;
	private Integer customerId;
	private Integer accountId;
	private BigDecimal ammount;
	private String transactionType;
	public Transaction(Integer transactionId, Integer customerId, Integer accountId, BigDecimal ammount,
			String transactionType) {
		super();
		this.transactionId = transactionId;
		this.customerId = customerId;
		this.accountId = accountId;
		this.ammount = ammount;
		this.transactionType = transactionType;
	}
	public Transaction() {
		super();
	}
	
}
