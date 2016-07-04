package edu.globant.day9.service.exercices.soap;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import edu.globant.day9.dao.hibernateimpl.ContactDaoImpl;
import edu.globant.day9.domain.Contact;
import edu.globant.day9.domain.ContactDetail;
import edu.globant.day9.domain.ContactDetailType;
import edu.globant.day9.service.exercices.soap.dtos.ContactDTO;
import edu.globant.day9.service.exercices.soap.dtos.ContactDetailDTO;
import edu.globant.day9.service.exercices.soap.dtos.ContactDetailTypeDTO;

@WebService(endpointInterface = "edu.globant.day9.service.exercices.soap.ContactService") 
public class ContactServiceImpl implements ContactService {

	ContactDaoImpl contactDao;
	
	public void createContact(ContactDTO contactDTO) {
		contactDao.save(ContactDTO.getContactFromContactDTO(contactDTO));
	}	

	@Override
	public ContactDTO getContact(Long id) {
		Contact contact = contactDao.findById(id);
		if(contact==null) return new ContactDTO();
		return ContactDTO.getContactDTOFromContact(contactDao.findById(id));
	}
	
	
}
