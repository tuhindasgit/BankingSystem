package com.training.retailerboot.exception;

public class MyException extends RuntimeException{
	String message;
	/**
	 * 
	 */
	private static final long serialVersionUID = -4609214656905222390L;






/**
	 * @param message
	 */
	public MyException(String message) {
		super();
		this.message = message;
	}






@Override
public String toString() {
	return "MyException []";
}
	

}
