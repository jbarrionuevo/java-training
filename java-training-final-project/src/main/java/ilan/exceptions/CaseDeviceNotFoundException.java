package ilan.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason = "Case Device not found")
public class CaseDeviceNotFoundException {
	public CaseDeviceNotFoundException(String name){}
	public CaseDeviceNotFoundException(Long id){}
}
