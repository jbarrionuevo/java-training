package edu.globant.day2.collections.exercices.set;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import edu.globant.day2.collections.exercices.list.PhoneContact;

public class PhoneContactWithSets {
	
	public static void main(String[] args) {
		Set<PhoneContact> phoneBook = addNumbers(new TreeSet<PhoneContact>());
		System.out.println("Print book, authomatically ordered for being a treeset and for implementing the PhoneContact class the Comparable interface");
		System.out.println(phoneBook);
		System.out.println("Get phones from people whose last name starts with r");
		System.out.println(phoneBook.stream().filter(p->p.getLastName().startsWith("r")).collect(Collectors.toList()));
		System.out.println("Add a new number; its added in order");
		PhoneContact newPhoneContact = new PhoneContact("new", "newLastName", "4567123");
		phoneBook.add(newPhoneContact);
		System.out.println(phoneBook);
		System.out.println("Add the same number; its not added! It doesnt admit repeated elements");
		phoneBook.add(newPhoneContact);
		System.out.println(phoneBook);
	}
	
	public static Set<PhoneContact> addNumbers(Set<PhoneContact> phoneBook){
		phoneBook.add(new PhoneContact("ilan", "rosenfeld", "1234567"));
		phoneBook.add(new PhoneContact("john", "coltraine", "7654321"));
		phoneBook.add(new PhoneContact("miles", "davis", "3456712"));
		phoneBook.add(new PhoneContact("charlie", "parker", "2345671"));
		phoneBook.add(new PhoneContact("dexter", "gordon", "5671234"));
		return phoneBook;
	}
}
