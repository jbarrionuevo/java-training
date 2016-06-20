package edu.globant.day2.exceptions;

public class BillGenerationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BillGenerationException(String message) {
		super(message);
	}

	public BillGenerationException(String message, Throwable cause) {
		super(message, cause);
	}
}
