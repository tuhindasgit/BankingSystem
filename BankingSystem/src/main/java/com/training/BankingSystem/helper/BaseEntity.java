package com.training.BankingSystem.helper;

import javax.persistence.MappedSuperclass;
/**
 * 
 * @author tuhin
 *
 */
@MappedSuperclass
public class BaseEntity {

	private String userId;
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(final String userId) {
		this.userId = userId;
	}
/**
 * 
 * @param userId
 */
	public BaseEntity(final String userId) {
		super();
		this.userId = userId;
	}
/**
 * no parameter constructor
 */
	public BaseEntity() {
		super();
	}
	
}
