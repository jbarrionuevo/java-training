package edu.globant.day2.exercises.collections;

import java.util.ArrayList;
import java.util.List;

public class ContactArrayList {

	public List<Contact> contactList = new ArrayList<Contact>();
	public void contactsToArray(Contact contact){
		contactList.add(contact);
		System.out.println(contact);
	}
}
