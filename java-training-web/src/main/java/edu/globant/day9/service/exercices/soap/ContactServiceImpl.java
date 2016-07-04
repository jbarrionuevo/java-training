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
		contactDao.save(getContactFromContactDTO(contactDTO));
	}	

	@Override
	public ContactDTO getContact(Long id) {
		Contact contact = contactDao.findById(id);
		if(contact==null) return new ContactDTO();
		return getContactDTOFromContact(contactDao.findById(id));
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
	
	public ContactDTO getContactDTOFromContact(Contact contact){
		ContactDTO contactDTO = new ContactDTO();
		contactDTO.setBirthday(contact.getBirthday());
		contactDTO.setCreationDate(contact.getCreationDate());
		contactDTO.setFirstName(contact.getFirstName());
		contactDTO.setLastName(contact.getLastName());
		List<ContactDetailDTO> details = new ArrayList<ContactDetailDTO>();
		for(ContactDetail cd: contact.getContactDetailList()){
			ContactDetailDTO detail = new ContactDetailDTO();
			detail.setDetails(cd.getDetails());
			detail.setCreationDate(cd.getCreationDate());
			ContactDetailTypeDTO dt = new ContactDetailTypeDTO();
			dt.setDescription(cd.getContactDetailType().getDescription());
			detail.setContactDetailType(dt);
			details.add(detail);
		}
		contactDTO.setContactDetailList(details);
		return contactDTO;
	}
}
