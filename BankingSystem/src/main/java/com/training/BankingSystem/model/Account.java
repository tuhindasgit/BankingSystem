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
@Entity
@Data
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer accountId;
	private Integer customerId;
	private Integer bankId;
	private BigDecimal ammount;

	@OneToMany(targetEntity=Transaction.class,mappedBy="accountId")
	private List<Transaction> accountTransactionList=new ArrayList<>();
	
	public Account(Integer customerId, Integer bankId, BigDecimal ammount) {
		super();
		this.customerId = customerId;
		this.bankId = bankId;
		this.ammount = ammount;
	}
	public Account() {
		super();
	}

}
