package com.training.BankingSystem.model;

import javax.persistence.MappedSuperclass;

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
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public BaseEntity(String userId) {
		super();
		this.userId = userId;
	}

	public BaseEntity() {
		super();
	}
	
}
