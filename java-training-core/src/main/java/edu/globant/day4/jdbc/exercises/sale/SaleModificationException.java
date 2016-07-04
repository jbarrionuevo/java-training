package edu.globant.day4.jdbc.exercises.sale;

public class SaleModificationException extends Exception {
	
	public SaleModificationException(String message) {
		super(message);
	}

	public SaleModificationException(String message, Throwable cause) {
		super(message, cause);
	}

}
