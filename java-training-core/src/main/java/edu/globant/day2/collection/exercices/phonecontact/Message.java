package edu.globant.day2.collection.exercices.phonecontact;

import java.util.Date;

public class Message {

	private String phoneNumber;
	private String message;
	private Date receiveDate;
	
	public Message(String phoneNumber, String message, Date receiveDate) {
		this.phoneNumber = phoneNumber;
		this.message = message;
		this.receiveDate = receiveDate;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getMessage() {
		return message;
	}

	public Date getReceiveDate() {
		return receiveDate;
	}
}
