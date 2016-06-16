package edu.globant.day2.collections.PhoneContact;

import java.util.TreeMap;

public class PhoneContact_Map {
	public static void main(String[] args) {
		TreeMap<PhoneContact,String> phones = new TreeMap<PhoneContact,String>();
		addPhones(phones);
		
		System.out.println("Phones: \n"+phones);
		System.out.println("Adding a new phone...");
		
		PhoneContact p3 = new PhoneContact("john", "yuta", "66266");
		phones.put(p3,p3.getPhone());
		System.out.println(phones);
		
		System.out.println("Adding a new phone 2...");
		
		PhoneContact p4 = new PhoneContact("hello", "world", "111");
		phones.put(p4,p4.getPhone());
		System.out.println(phones);
	}

	private static void addPhones(TreeMap<PhoneContact,String> phones) {
		PhoneContact p1 = new PhoneContact("dante", "salamone", "123123");
		phones.put(p1,p1.getPhone());
		
		PhoneContact p2= new PhoneContact("pepe", "pipon", "1213131313141");
		phones.put(p2,p2.getPhone());
	}
}
