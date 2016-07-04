package edu.globant.day9.service.exercices.soap.dtos;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.util.Date;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

import edu.globant.day9.domain.Contact;
import edu.globant.day9.domain.ContactDetailType;

public class ContactDetailDTO extends BaseEntityDTO{
	private String details;
	private Date creationDate;
	private ContactDetailTypeDTO contactDetailType;

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public ContactDetailTypeDTO getContactDetailType() {
		return contactDetailType;
	}

	public void setContactDetailType(ContactDetailTypeDTO contactDetailType) {
		this.contactDetailType = contactDetailType;
	}
}
