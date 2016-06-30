package ilan.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason = "Case Seller not found")
public class CaseSellerNotFoundException extends RuntimeException{
	public CaseSellerNotFoundException(Long id){
		
	}
}
