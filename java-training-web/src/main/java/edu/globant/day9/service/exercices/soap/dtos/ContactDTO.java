package edu.globant.day9.service.exercices.soap.dtos;

import java.util.Date;
import java.util.List;

import edu.globant.day9.domain.ContactDetail;

public class ContactDTO extends BaseEntityDTO {
	private String firstName;
	private String lastName;
	private Date birthday;
	private Date creationDate;
	private List<ContactDetailDTO> contactDetailList;

	public String getFirstName() {
		return firstName;
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
