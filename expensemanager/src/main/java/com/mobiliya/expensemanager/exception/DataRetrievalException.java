package com.mobiliya.expensemanager.exception;

/**
 * The Class DataRetrievalException.
 */
public class DataRetrievalException extends RuntimeException{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new data retrieval exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public DataRetrievalException(String message, Throwable cause) {
		super(message,cause);
	}
}
