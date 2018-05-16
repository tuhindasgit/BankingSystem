package com.training.BankingSystem.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Entity
@Data
public class ATM {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer ATMId;
	private BigDecimal ammount;
	private Integer bankId;
	public ATM(BigDecimal ammount, Integer bankId) {
		super();
		this.ammount = ammount;
		this.bankId = bankId;
	}
	public ATM() {
		super();
	}
	
}
