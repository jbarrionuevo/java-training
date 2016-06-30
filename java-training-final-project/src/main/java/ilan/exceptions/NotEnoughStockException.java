package ilan.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason = "Not enough stock of the case")
public class NotEnoughStockException extends RuntimeException {
	public NotEnoughStockException(String aCase){}

}
