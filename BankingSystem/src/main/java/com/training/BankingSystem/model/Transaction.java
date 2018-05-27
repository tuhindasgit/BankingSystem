package com.training.BankingSystem.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import com.training.BankingSystem.helper.BaseEntity;
@Entity

@Component
public class Transaction extends BaseEntity{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer transactionId;
	private Integer customerId;
	private Integer accountId;
	private BigDecimal ammount;
	private String transactionType;
/**
 * Parameterized constructor
 * 
 */
			
	public Transaction( final Integer customerId, final Integer accountId, final BigDecimal ammount,
			final String transactionType) {
		super();
		this.customerId = customerId;
		this.accountId = accountId;
		this.ammount = ammount;
		this.transactionType = transactionType;
	} 
	/**
	 * no parameter constructor
	 */
	public Transaction() {
		super();
	}
	/**
	 * @return the transactionId
	 */
	public Integer getTransactionId() {
		return transactionId;
	}
	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(final Integer transactionId) {
		this.transactionId = transactionId;
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
	public void setCustomerId(final Integer customerId) {
		this.customerId = customerId;
	}
	/**
	 * @return the accountId
	 */
	public Integer getAccountId() {
		return accountId;
	}
	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(final Integer accountId) {
		this.accountId = accountId;
	}
	/**
	 * @return the ammount
	 */
	public BigDecimal getAmmount() {
		return ammount;
	}
	/**
	 * @param ammount the ammount to set
	 */
	public void setAmmount(final BigDecimal ammount) {
		this.ammount = ammount;
	}
	/**
	 * @return the transactionType
	 */
	public String getTransactionType() {
		return transactionType;
	}
	/**
	 * @param transactionType the transactionType to set
	 */
	public void setTransactionType(final String transactionType) {
		this.transactionType = transactionType;
	}
	
}
