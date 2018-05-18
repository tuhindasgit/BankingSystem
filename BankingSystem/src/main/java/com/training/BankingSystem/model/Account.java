package com.training.BankingSystem.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import lombok.Data;
/*
 * @Tuhin Das
 * Account Entity class
 */
@Entity
@Data
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer accountId;
	private Integer customerId;
	private Integer bankId;
	private BigDecimal ammount;
/*
 * Mapping with Transaction
 */
	@OneToMany(targetEntity=Transaction.class,mappedBy="accountId")
	private List<Transaction> accountTransactionList=new ArrayList<>(); 
	/*
	 * parameterized constructor
	 */
	public Account(final Integer customerId,final Integer bankId,final BigDecimal ammount) {
		super();
		this.customerId = customerId;
		this.bankId = bankId;
		this.ammount = ammount;
	}
	public Account() {
		super();
	}

}
