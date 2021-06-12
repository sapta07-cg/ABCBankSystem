package com.capgemini.exception;

public class UserLoginException extends RuntimeException{
	public UserLoginException() {
		super();
	}

	public UserLoginException(String message) {
		super(message);
	}

}
