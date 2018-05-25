package com.training.micro.audit.exception;
/**
 * 
 * @author tuhin
 *
 */
public class AuditException extends RuntimeException {
	
	private String message;
	
	public AuditException(String message)
	{
		super();
		this.message=message;
	}

	/**
	 * to print the defined exception
	 */
	@Override
	public String toString() {
		return "AuditException [message=" + message + "]";
	}

	
}
