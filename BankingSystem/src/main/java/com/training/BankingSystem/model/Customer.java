package com.training.BankingSystem.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;
/*
 * Entity class for Customer
 */
@Entity

@Component
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer customerId;
	private String name;
	private Integer pin;
	private Integer bankId;
	/*
	 * mapping of Transaction
	 */
	@OneToMany(targetEntity=Account.class,mappedBy="customerId")
	private List<Account> customerAccountList=new ArrayList<>();
	/*
	 * mapping for Transaction
	 */
	@OneToMany(targetEntity=Transaction.class,mappedBy="customerId")
	private List<Transaction> transactionList=new ArrayList<>();
	/*
	 * parameterized constructor
	 */
	public Customer(String name, Integer pin, Integer bankId) {
		super();
		this.name = name;
		this.pin = pin;
		this.bankId = bankId;
	}
	public Customer() {
		super();
	}
	/**
	 * @return the customerId
	 */
	public Integer getCustomerId() {
		return customerId;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the pin
	 */
	public Integer getPin() {
		return pin;
	}
	/**
	 * @param pin the pin to set
	 */
	public void setPin(Integer pin) {
		this.pin = pin;
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
	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}
	
	
}
