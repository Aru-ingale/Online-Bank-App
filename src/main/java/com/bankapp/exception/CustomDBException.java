package com.bankapp.exception;

public class CustomDBException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CustomDBException(String errorMessage) {
		super(errorMessage);
	}
	

}
