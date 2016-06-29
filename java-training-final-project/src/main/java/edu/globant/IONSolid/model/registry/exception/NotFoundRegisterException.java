package edu.globant.IONSolid.model.registry.exception;

public class NotFoundRegisterException extends Exception {
	
	public NotFoundRegisterException(String message) {
		super(message);
	}

	public NotFoundRegisterException(String message, Throwable cause) {
		super(message, cause);
	}
}
