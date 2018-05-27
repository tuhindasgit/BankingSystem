package com.training.BankingSystem.exception;
/**
 * Creating MyException
 */
public class MyException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -973182538952658229L;

	private String message;
/**
 * Constructor that sends message
 */
	public MyException(final String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return  "message= " + message;
	}

}
