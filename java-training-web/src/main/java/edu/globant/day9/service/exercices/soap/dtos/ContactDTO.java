package edu.globant.day9.service.exercices.soap.dtos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.globant.day9.domain.Contact;
import edu.globant.day9.domain.ContactDetail;
import edu.globant.day9.domain.ContactDetailType;

public class ContactDTO extends BaseEntityDTO {
	private String firstName;
	private String lastName;
	private Date birthday;
	private Date creationDate;
	private List<ContactDetailDTO> contactDetailList;

	public String getFirstName() {
		return firstName;
	}

	public static Contact getContactFromContactDTO(ContactDTO contactDTO){
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
	
	public static ContactDTO getContactDTOFromContact(Contact contact){
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
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public List<ContactDetailDTO> getContactDetailList() {
		return contactDetailList;
	}

	public void setContactDetailList(List<ContactDetailDTO> contactDetailList) {
		this.contactDetailList = contactDetailList;
	}

}
