package edu.globant.IONSolid.model.registry.exception;

public class AlreadyExistRegisterException extends Exception {
	
	public AlreadyExistRegisterException(String message) {
		super(message);
	}

	public AlreadyExistRegisterException(String message, Throwable cause) {
		super(message, cause);
	}
}
