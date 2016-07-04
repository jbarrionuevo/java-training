package ilan.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason = "Case Product not found")
public class CaseProductNotFoundException extends RuntimeException {
	public CaseProductNotFoundException(Long productId){}
}
