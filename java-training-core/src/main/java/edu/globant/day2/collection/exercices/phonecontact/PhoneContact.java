package edu.globant.day2.collection.exercices.phonecontact;

import java.util.Date;

public class PhoneContact {

	private String contactName;
	private String contactNumber;
	private Date addedDate;
	
	public PhoneContact(String name, String number, Date addedDate) {
		this.contactName = name;
		this.contactNumber = number;
		this.addedDate = addedDate;
	}
	
	public String getContactName() {
		return contactName;
	}
	
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	
	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}	
}
