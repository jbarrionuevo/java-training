package ilan.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason = "Case Wrapper not found")
public class CaseWrapperNotFoundException extends RuntimeException {
	public CaseWrapperNotFoundException(String name){}

}
