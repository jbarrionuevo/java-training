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

@WebService(endpointInterface = "edu.globant.day9.service.exercices.soap.ContactService") 
public class ContactServiceImpl implements ContactService {

	ContactDaoImpl contactDao;
	
	public void createContact(ContactDTO contactDTO) {
		contactDao.save(getContactFromContactDTO(contactDTO));
	}	
	
	private Contact getContactFromContactDTO(ContactDTO contactDTO){
		Contact contact = new Contact();
		contact.setBirthday(contactDTO.getBirthday());
		contact.setCreationDate(contactDTO.getCreationDate());
		contact.setFirstName(contactDTO.getFirstName());
		contact.setLastName(contactDTO.getLastName());
		List<ContactDetail> details = new ArrayList<ContactDetail>();
		for(ContactDetailDTO cd: contactDTO.getContactDetailList()){
			ContactDetail detail = new ContactDetail();
			detail.setDetails(cd.getDetails());
			detail.setCreationDate(cd.getCreationDate());
			ContactDetailType dt = new ContactDetailType();
			dt.setDescription(cd.getContactDetailType().getDescription());
			detail.setContactDetailType(dt);
			details.add(detail);
		}
		contact.setContactDetailList(details);
		return contact;
	}
}
