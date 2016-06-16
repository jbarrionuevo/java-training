package edu.globant.day2.collections.PhoneContact;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PhoneContact_List {
	public static void main(String[] args) {
		ArrayList<PhoneContact> phones = new ArrayList<PhoneContact>();

		phones.add(new PhoneContact("dante", "salamone", "111"));
		phones.add(new PhoneContact("pepe", "pipon", "333"));
		phones.add(new PhoneContact("john", "yuta", "222"));
		
		System.out.println("No order");
		System.out.println(phones);
		
		System.out.println("\n");
		
		System.out.println("lastname order");
		Collections.sort(phones,PhoneContact.LastNameComparator);
		System.out.println(phones);
		
		System.out.println("\n");
		
		System.out.println("phone order");
		Collections.sort(phones,PhoneContact.PhoneComparator);
		System.out.println(phones);
	}
}
