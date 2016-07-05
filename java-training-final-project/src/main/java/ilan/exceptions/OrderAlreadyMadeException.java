package ilan.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason = "Order Alert not found")
public class OrderAlreadyMadeException extends RuntimeException{
	public OrderAlreadyMadeException(Long id){}
}
