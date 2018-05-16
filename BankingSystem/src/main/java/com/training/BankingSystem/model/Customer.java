package com.training.BankingSystem.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer customerId;
	private String name;
	private Integer pin;
	private Integer bankId;
	
	@OneToMany(targetEntity=Account.class,mappedBy="customerId")
	private List<Account> customerAccountList=new ArrayList<>();
	
	@OneToMany(targetEntity=Transaction.class,mappedBy="customerId")
	private List<Transaction> transactionList=new ArrayList<>();
	
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
