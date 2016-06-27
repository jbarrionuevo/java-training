package edu.globant.day2.collection.exercices.phonebook.message;

import java.util.Comparator;

public class MessageComparator implements Comparator<Message> {

	@Override
	public int compare(Message o1, Message o2) {
		o1.getReceiveDate().compareTo(o2.getReceiveDate());
		return 0;
	}

}
