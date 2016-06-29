package edu.globant.IONSolid.services.sale.exception;

public class SaleServiceException extends Exception {
	
	public SaleServiceException(String message) {
		super(message);
	}

	public SaleServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}
