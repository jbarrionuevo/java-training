package ilan.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason = "Sale not found")
public class SaleNotFoundException extends RuntimeException{
	public SaleNotFoundException(Long id){}
}
