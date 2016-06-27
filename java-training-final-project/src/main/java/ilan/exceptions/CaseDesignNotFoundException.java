package ilan.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason = "Case Design not found")
public class CaseDesignNotFoundException extends RuntimeException {
	public CaseDesignNotFoundException(String name){
		
	}
}
