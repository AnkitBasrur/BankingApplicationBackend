package com.lti.bank.exceptions;

public class IncorrectAmountException extends RuntimeException{

	public IncorrectAmountException(String message) {
		super(message);
	}
	
	public IncorrectAmountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public IncorrectAmountException(String message, Throwable cause) {
		super(message, cause);
	}

	public IncorrectAmountException(Throwable cause) {
		super(cause);
	}
}
