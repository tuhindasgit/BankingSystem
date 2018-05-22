package com.training.BankingSystem.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
@Entity

@Component
public class Transaction {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer transactionId;
	private Integer customerId;
	private Integer accountId;
	private BigDecimal ammount;
	private String transactionType;
/*
 * Parameterized constructor
 * 
 */
			
	public Transaction( Integer customerId, Integer accountId, BigDecimal ammount,
			String transactionType) {
		super();
		this.customerId = customerId;
		this.accountId = accountId;
		this.ammount = ammount;
		this.transactionType = transactionType;
	} 
	public Transaction() {
		super();
	}
	
}
