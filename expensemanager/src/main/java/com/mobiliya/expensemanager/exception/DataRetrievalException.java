package com.mobiliya.expensemanager.exception;

public class DataRetrievalException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public DataRetrievalException(String message, Throwable cause) {
		super(message,cause);
	}
}
