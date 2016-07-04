package edu.globant.day9.service.exercices.soap;

import java.util.ArrayList;

import java.util.Collection;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import edu.globant.day9.dao.hibernateimpl.ContactDaoImpl;
import edu.globant.day9.domain.Contact;
import edu.globant.day9.domain.ContactDetail;
import edu.globant.day9.domain.ContactDetailType;
import edu.globant.day9.service.exercices.soap.dtos.ContactDTO;
import edu.globant.day9.service.exercices.soap.dtos.ContactDetailDTO;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface ContactService {
	
		
	@WebMethod
	public void createContact(ContactDTO contactDTO);		
	
	@WebMethod
	public ContactDTO getContact(Long id);
}
