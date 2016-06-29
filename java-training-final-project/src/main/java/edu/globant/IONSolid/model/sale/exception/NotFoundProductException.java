package edu.globant.IONSolid.model.sale.exception;

public class NotFoundProductException extends Exception {
	
	public NotFoundProductException(String message) {
		super(message);
	}

	public NotFoundProductException(String message, Throwable cause) {
		super(message, cause);
	}

}
