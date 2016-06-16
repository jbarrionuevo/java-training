package edu.globant.day2.collections.PhoneContact;

import java.util.Comparator;

public class PhoneContact implements Comparable{
	private String name,lastname,phone;
	
	public PhoneContact(String name, String lastname, String phone){
		this.name = name;
		this.lastname= lastname;
		this.phone = phone;
	}
	
	@Override
	public String toString(){
		return String.format("%s, %s: %s", this.getLastname(), this.getName(), this.getPhone());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public int compareTo(Object phone) {
		return this.getLastname().toUpperCase().compareTo(((PhoneContact) phone).getLastname().toUpperCase());
	}
	
	public static Comparator<PhoneContact> LastNameComparator = new Comparator<PhoneContact>(){
		public int compare(PhoneContact p1, PhoneContact p2){
			return p1.getLastname().compareTo(p2.getLastname());
		}
	};
	
	public static Comparator<PhoneContact> PhoneComparator = new Comparator<PhoneContact>(){
		public int compare(PhoneContact p1, PhoneContact p2){
			return p1.getPhone().compareTo(p2.getPhone());
		}
	};
	
}
