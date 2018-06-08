package com.javasampleapproach.entity;

import java.io.Serializable;
import java.math.BigDecimal;


public class Bank implements Serializable {

	private static final long serialVersionUID = 6853282395610216027L;
	private Integer bankId;
	private BigDecimal amount;

	public Integer getBankId() {
		return bankId;
	}

	public void setBankId(final Integer bankId) {
		this.bankId = bankId;
		
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(final BigDecimal amount) {
		this.amount = amount;
	}

	

	public Bank() {
		super();
	}


	@Override
	public String toString() {
		return "Bank [bankId=" + bankId + ", amount=" + amount + "]";
	}
	public Bank(Integer bankId, BigDecimal amount) {
		super();
		this.bankId = bankId;
		this.amount = amount;
	}
	

}

