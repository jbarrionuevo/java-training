package edu.globant.day2.collections.exercices.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

//
public class PhoneContactWithLists {
	
	public static void main(String[] args) {
		ArrayList<PhoneContact> phoneBook = addNumbers(new ArrayList<PhoneContact>());
		System.out.println("Print without order");
		System.out.println(phoneBook);
		System.out.println("Print ordered by Last Name");
		Collections.sort(phoneBook,PhoneContact.PhoneContactLastNameComparator);
		System.out.println(phoneBook);
		System.out.println("Print ordered by Phone Number");
		Collections.sort(phoneBook,PhoneContact.PhoneContactPhoneNumberComparator);
		System.out.println(phoneBook);
		
		System.out.println("Get phones from people whose last name starts with r");
		System.out.println(phoneBook.stream().filter(p->p.getLastName().startsWith("r")).collect(Collectors.toList()));
	}
	
	public static ArrayList<PhoneContact> addNumbers(ArrayList<PhoneContact> phoneBook){
		phoneBook.add(new PhoneContact("ilan", "rosenfeld", "1234567"));
		phoneBook.add(new PhoneContact("john", "coltraine", "7654321"));
		phoneBook.add(new PhoneContact("miles", "davis", "3456712"));
		phoneBook.add(new PhoneContact("charlie", "parker", "2345671"));
		phoneBook.add(new PhoneContact("dexter", "gordon", "5671234"));
		return phoneBook;
	}
	
}
