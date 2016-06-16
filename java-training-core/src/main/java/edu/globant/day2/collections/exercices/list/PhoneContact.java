package edu.globant.day2.collections.exercices.list;

import java.util.Comparator;

public class PhoneContact {
	private String firstName,lastName,phoneNumber;

	
	public PhoneContact(String firstName, String lastName, String phoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public String toString(){
		return String.format("%s, %s: %s", this.getLastName(), this.getFirstName(), this.getPhoneNumber());
	}
	
	public static Comparator<PhoneContact> PhoneContactLastNameComparator = new Comparator<PhoneContact>() {

		public int compare(PhoneContact p1, PhoneContact p2) {
		   //ascending order
		   return p1.getLastName().toLowerCase().compareTo(p2.getLastName().toLowerCase());
	}};
	
	public static Comparator<PhoneContact> PhoneContactPhoneNumberComparator = new Comparator<PhoneContact>() {

		public int compare(PhoneContact p1, PhoneContact p2) {
		   //ascending order
		   return p1.getPhoneNumber().compareTo(p2.getPhoneNumber());
	}};

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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}
