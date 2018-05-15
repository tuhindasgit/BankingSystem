package com.training.BankingSystem.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="bank")
public class Bank {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="bankId")
	private Integer bankId;
	@Column(name="ammount")
	private BigDecimal ammount;
	
	
	public Bank(Integer bankId, BigDecimal ammount) {
		super();
		this.bankId = bankId;
		this.ammount = ammount;
	}
	
}
