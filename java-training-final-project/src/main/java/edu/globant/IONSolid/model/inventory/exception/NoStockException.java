package edu.globant.IONSolid.model.inventory.exception;

public class NoStockException extends Exception {
	
	public NoStockException(String message) {
		super(message);
	}

	public NoStockException(String message, Throwable cause) {
		super(message, cause);
	}
}
