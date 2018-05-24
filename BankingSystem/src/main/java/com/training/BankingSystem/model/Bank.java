package com.training.BankingSystem.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.training.BankingSystem.helper.BaseEntity;
/**
 * 
 * @author tuhin
 *
 */
@Entity
@Table(name = "bank")
public class Bank extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bankId;
	private BigDecimal amount;
	/**
	 * mapping between customer and bank
	 */
	@OneToMany(targetEntity=Customer.class,mappedBy="bankId")
	private List<Customer> bankCustomerList = new ArrayList<>();
	/*
	 * mapping between atm and bank
	 */
	@OneToMany(targetEntity=ATM.class,mappedBy="bankId")
	private List<ATM> bankAtmList=new ArrayList<>();
	/*
	 * mapping between account and atm
	 */
	@OneToMany(targetEntity=Account.class,mappedBy="bankId")
	private List<Account> bankAccountList=new ArrayList<>();
	/**
	 * 
	 * @param amount
	 */
	public Bank(final BigDecimal amount) {
		super();
		this.amount = amount;
	}
/**
 * no parameter constructor
 */
public Bank() {
	super();
}
/**
 * constructor with parameter
 */
public Bank(final Integer bankId,final BigDecimal amount) {
	super();
	this.bankId = bankId;
	this.amount = amount;
}

/**
 * @return the bankId
 */
public Integer getBankId() {
	return bankId;
}

/**
 * @param bankId the bankId to set
 */
public void setBankId(final Integer bankId) {
	this.bankId = bankId;
}

/**
 * @return the amount
 */
public BigDecimal getAmount() {
	return amount;
}

/**
 * @param amount the amount to set
 */
public void setAmount(final BigDecimal amount) {
	this.amount = amount;
}


}
