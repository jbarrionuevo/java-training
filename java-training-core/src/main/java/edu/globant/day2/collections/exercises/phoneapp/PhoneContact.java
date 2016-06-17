package edu.globant.day2.collections.exercises.phoneapp;

import java.util.Comparator;

public class PhoneContact implements Comparable {

	private String phone;
	private String name;

	public PhoneContact(String phone, String name) {
		this.phone = phone;
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Object phonecontact) {
		return this.getName().toLowerCase().compareTo(((PhoneContact) phonecontact).getName().toLowerCase());
	}

	public static Comparator<PhoneContact> nameComparator = new Comparator<PhoneContact>() {
		public int compare(PhoneContact p1, PhoneContact p2) {
			return p1.getName().compareTo(p2.getName());
		}
	};

	public static Comparator<PhoneContact> phoneComparator = new Comparator<PhoneContact>() {
		public int compare(PhoneContact p1, PhoneContact p2) {
			return p1.getPhone().compareTo(p2.getPhone());
		}
	};

	@Override
	public String toString() {
		return this.getName() + "  " + this.getPhone();
	}

}
