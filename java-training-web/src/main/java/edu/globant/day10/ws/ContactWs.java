package edu.globant.day10.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import edu.globant.day10.dto.ContactDto;

@WebService
@SOAPBinding(style=Style.DOCUMENT)
public interface ContactWs {

	@WebMethod
	List<ContactDto> getContactList();
}
