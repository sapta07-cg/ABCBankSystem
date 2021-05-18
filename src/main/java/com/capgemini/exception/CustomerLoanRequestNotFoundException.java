package com.capgemini.exception;

public class CustomerLoanRequestNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public CustomerLoanRequestNotFoundException() {
		super();
	}

	public CustomerLoanRequestNotFoundException(String message) {
		super(message);
	}

}
