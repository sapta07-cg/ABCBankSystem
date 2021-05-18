package com.capgemini.exception;

public class CustomerDetailsNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public CustomerDetailsNotFoundException() {
		super();
	}
	
	public CustomerDetailsNotFoundException(String message) {
		super(message);
	}

}
