package com.training.BankingSystem.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.training.BankingSystem.helper.BaseEntity;
/**
 * @author trainee
 *
 */
@Entity
public class ATM extends BaseEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer ATMId;
	private BigDecimal ammount;
	private Integer bankId;
	/**
	 * Parameterized Constructor 
	 */
	public ATM(final BigDecimal ammount, final Integer bankId) {
		super();
		this.ammount = ammount;
		this.bankId = bankId;
	}
	/**
	 * no parameter constructor
	 */
	public ATM() {
		super();
	}
	/**
	 * @return the aTMId
	 */
	public Integer getATMId() {
		return ATMId;
	}
	/**
	 * @param aTMId the aTMId to set
	 */
	public void setATMId(final Integer aTMId) {
		ATMId = aTMId;
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
	
}
