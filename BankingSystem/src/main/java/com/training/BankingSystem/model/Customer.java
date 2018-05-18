package com.training.BankingSystem.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import lombok.Data;
/*
 * Entity class for Customer
 */
@Entity
@Data
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
	
	
}
