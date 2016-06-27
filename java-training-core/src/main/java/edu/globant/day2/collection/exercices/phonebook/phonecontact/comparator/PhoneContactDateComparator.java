package edu.globant.day2.collection.exercices.phonebook.phonecontact.comparator;

import edu.globant.day2.collection.exercices.phonebook.phonecontact.PhoneContact;

public class PhoneContactDateComparator extends PhoneContactComparator {

	@Override
	public int compare(PhoneContact o1, PhoneContact o2) {
		return o1.getAddedDate().compareTo(o2.getAddedDate());
	}

}
