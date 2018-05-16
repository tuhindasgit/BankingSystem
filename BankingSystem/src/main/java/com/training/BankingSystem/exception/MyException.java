package com.training.BankingSystem.exception;

public class MyException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -973182538952658229L;

	String message;

	public MyException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return  "message= " + message;
	}

}
