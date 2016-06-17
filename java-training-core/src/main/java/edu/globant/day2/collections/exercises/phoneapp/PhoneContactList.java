package edu.globant.day2.collections.exercises.phoneapp;

import java.util.ArrayList;
import java.util.Collections;

public class PhoneContactList {
	public static void main(String[] args) {
		ArrayList<PhoneContact> contacts = new ArrayList<PhoneContact>();

		PhoneContact c1 = new PhoneContact("11111", "aname");
		PhoneContact c2 = new PhoneContact("33333", "cname");
		PhoneContact c4 = new PhoneContact("44444", "bname");

		contacts.add(c1);
		contacts.add(c2);
		contacts.add(c4);

		System.out.println("Printing");
		System.out.println(contacts);

		Collections.sort(contacts, PhoneContact.nameComparator);
		System.out.println("Printing in order");
		System.out.println(contacts);

		System.out.println("Printing contacts amount");
		System.out.println(contacts.size());

	}
}
