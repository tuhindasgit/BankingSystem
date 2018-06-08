package helper.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
/*
 * @Tuhin Das
 * Account Entity class
 */

public class Account extends BaseEntity {

	private Integer accountId;
	private Integer customerId;
	private Integer bankId;
	private BigDecimal ammount;
/*
 * Mapping with Transaction
 */
	@OneToMany(targetEntity=Transaction.class,mappedBy="accountId")
	private List<Transaction> accountTransactionList=new ArrayList<>(); 
	/*
	 * parameterized constructor
	 */
	public Account(final Integer customerId,final Integer bankId,final BigDecimal ammount) {
		super();
		this.customerId = customerId;
		this.bankId = bankId;
		this.ammount = ammount;
	}
	public Account() {
		super();
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
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
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
	/**
	 * @return the ammount
	 */
	public BigDecimal getAmmount() {
		return ammount;
	}
	/**
	 * @param ammount the ammount to set
	 */
	public void setAmmount(BigDecimal ammount) {
		this.ammount = ammount;
	}
	/**
	 * @return the accountTransactionList
	 */
	public List<Transaction> getAccountTransactionList() {
		return accountTransactionList;
	}
	/**
	 * @param accountTransactionList the accountTransactionList to set
	 */
	public void setAccountTransactionList(List<Transaction> accountTransactionList) {
		this.accountTransactionList = accountTransactionList;
	}

}
