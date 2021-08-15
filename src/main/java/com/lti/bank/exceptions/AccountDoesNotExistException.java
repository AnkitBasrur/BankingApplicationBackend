package com.lti.bank.exceptions;

public class AccountDoesNotExistException extends RuntimeException{

	public AccountDoesNotExistException(String message) {
		super(message);
	}
	
	public AccountDoesNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AccountDoesNotExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public AccountDoesNotExistException(Throwable cause) {
		super(cause);
	}
}
