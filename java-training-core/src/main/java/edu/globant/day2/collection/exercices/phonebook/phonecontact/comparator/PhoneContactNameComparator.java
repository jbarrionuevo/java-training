package edu.globant.day2.collection.exercices.phonebook.phonecontact.comparator;

import edu.globant.day2.collection.exercices.phonebook.phonecontact.PhoneContact;

public class PhoneContactNameComparator extends PhoneContactComparator {

	public int compare(PhoneContact o1, PhoneContact o2) {
		return o1.getContactName().compareTo(o2.getContactName());
	}

}
