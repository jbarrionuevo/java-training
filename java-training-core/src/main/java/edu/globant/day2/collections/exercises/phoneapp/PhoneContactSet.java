package edu.globant.day2.collections.exercises.phoneapp;

import java.util.Set;
import java.util.TreeSet;

public class PhoneContactSet {
	public static void main(String[] args) {
		Set<PhoneContact> contacts = new TreeSet<PhoneContact>();

		PhoneContact c1 = new PhoneContact("11111", "aname");
		PhoneContact c2 = new PhoneContact("33333", "cname");
		PhoneContact c3 = new PhoneContact("22222", "bname");

		contacts.add(c1);
		contacts.add(c2);
		contacts.add(c3);
		
		System.out.println("Printing ordered");
		System.out.println(contacts);
		
		System.out.println("Printing adding existing");
		contacts.add(c3);
		System.out.println(contacts);
		
		

	}
}
