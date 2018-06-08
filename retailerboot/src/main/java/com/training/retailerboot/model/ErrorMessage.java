package com.training.retailerboot.model;

public class ErrorMessage {
	private String errorMessage;
	private Integer errorId;
	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	/**
	 * @return the errorId
	 */
	public Integer getErrorId() {
		return errorId;
	}
	/**
	 * @param errorId the errorId to set
	 */
	public void setErrorId(Integer errorId) {
		this.errorId = errorId;
	}
	/**
	 * @param errorMessage
	 * @param errorId
	 */
	public ErrorMessage(String errorMessage, Integer errorId) {
		super();
		this.errorMessage = errorMessage;
		this.errorId = errorId;
	}
	/**
	 * 
	 */
	public ErrorMessage() {
		super();
	}
	

}
