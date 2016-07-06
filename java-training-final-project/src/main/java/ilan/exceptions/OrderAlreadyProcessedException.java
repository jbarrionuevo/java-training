package ilan.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason = "Order already processed!")
public class OrderAlreadyProcessedException extends RuntimeException{
	public OrderAlreadyProcessedException(Long id){}
}
