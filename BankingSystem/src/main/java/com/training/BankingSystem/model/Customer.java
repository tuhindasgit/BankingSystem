package com.training.BankingSystem.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	private List<ATM> customerAccountList=new ArrayList<>();
	
	@OneToMany(targetEntity=Transaction.class,mappedBy="customerId")
	private List<Transaction> transactionList=new ArrayList<>();
	
	public Customer(Integer customerId, String name, Integer pin, Integer bankId) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.pin = pin;
		this.bankId = bankId;
	}
	public Customer() {
		super();
	}
	
	
}
