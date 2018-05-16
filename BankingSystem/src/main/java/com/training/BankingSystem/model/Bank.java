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

import lombok.Data;

@Entity
@Data
@Table(name = "bank")
public class Bank {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bankId;
	private BigDecimal ammount;
	
	@OneToMany(targetEntity=Customer.class,mappedBy="bankId")
	private List<Customer> bankCustomerList = new ArrayList<>();
	
	@OneToMany(targetEntity=ATM.class,mappedBy="bankId")
	private List<ATM> bankAtmList=new ArrayList<>();
	
	@OneToMany(targetEntity=Account.class,mappedBy="bankId")
	private List<ATM> bankAccountList=new ArrayList<>();
	
	public Bank(Integer bankId, BigDecimal ammount) {
		super();
		this.bankId = bankId;
		this.ammount = ammount;
	}

}
