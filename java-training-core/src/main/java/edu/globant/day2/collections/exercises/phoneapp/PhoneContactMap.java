package edu.globant.day2.collections.exercises.phoneapp;


import java.util.TreeMap;


public class PhoneContactMap {
	public static void main(String[] args) {
		TreeMap<PhoneContact,String> contacts = new TreeMap<PhoneContact,String>();

		PhoneContact c1 = new PhoneContact("11111", "aname");
		PhoneContact c2 = new PhoneContact("33333", "cname");
		PhoneContact c3 = new PhoneContact("22222", "bname");
		PhoneContact c4 = new PhoneContact("44444", "bname");
		
		contacts.put(c1,"123");
		contacts.put(c2,"311");
		contacts.put(c4,"242");
		
		System.out.println("Printing ordered");
		System.out.println(contacts);
		
		
		System.out.println("Printing added in order");
		contacts.put(c3,"155");
		System.out.println(contacts);
		
		

	}
}
