package edu.globant.testing.unit.exercise.sale;

public class NotFoundProductDetailException extends Exception {
	
	public NotFoundProductDetailException(String message) {
		super(message);
	}

	public NotFoundProductDetailException(String message, Throwable cause) {
		super(message, cause);
	}

}
