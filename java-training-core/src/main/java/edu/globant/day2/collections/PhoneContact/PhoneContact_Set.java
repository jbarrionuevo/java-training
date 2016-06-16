package edu.globant.day2.collections.PhoneContact;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PhoneContact_Set {
	public static void main(String[] args) {
		Set<PhoneContact> phones = new HashSet<PhoneContact>(); 
		
		phones.add(new PhoneContact("dante", "salamone", "123123"));
		phones.add(new PhoneContact("pepe", "pipon", "1213131313141"));
		phones.add(new PhoneContact("john", "yuta", "66266"));
		
		PhoneContact p1 = new PhoneContact("1","new phone","777");
		PhoneContact p2 = new PhoneContact("2","new phone","14145");
		
		System.out.println("Original Phones");
		System.out.println(phones);
		
		System.out.println("Adding 2 unexisting phones");
		phones.add(p1);
		phones.add(p2);
		System.out.println(phones);
		
		System.out.println("Adding an existing phone");
		phones.add(p1);
		System.out.println(phones);
	}
}
