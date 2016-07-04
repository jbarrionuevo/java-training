package edu.globant.day4.jdbc.exercises.sale;

public class NotFoundProductDetailException extends Exception {
	
	public NotFoundProductDetailException(String message) {
		super(message);
	}

	public NotFoundProductDetailException(String message, Throwable cause) {
		super(message, cause);
	}

}
