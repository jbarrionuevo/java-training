package edu.globant.day2.collection.exercices.phonebook;

import java.util.Deque;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

import edu.globant.day2.collection.exercices.phonebook.dataaccess.DataBaseAccess;
import edu.globant.day2.collection.exercices.phonebook.message.Message;
import edu.globant.day2.collection.exercices.phonebook.message.MessageComparator;
import edu.globant.day2.collection.exercices.phonebook.phonecontact.PhoneContact;
import edu.globant.day2.collection.exercices.phonebook.phonecontact.comparator.PhoneContactDateComparator;

public class PhoneBookDataLoader {

	private DataBaseAccess database;

	public PhoneBookDataLoader(DataBaseAccess db) {
		database = db;
	}

	public void loadPhoneBook(Set<PhoneContact> phoneBook) {
		List<PhoneContact> contacts = database.recoverPhoneContactData();
		for (PhoneContact contact : contacts) {
			phoneBook.add(contact);
		}
	}

	public void loadLastContactsAdded(Queue<PhoneContact> lastContactsAdded) {
		PhoneContactDateComparator cmp = new PhoneContactDateComparator();
		List<PhoneContact> contacts = database.recoverPhoneContactData();
		List<PhoneContact> contactsOrderedByDate = contacts.stream().sorted((a, b) -> cmp.compare(b, a)).limit(5)
				.collect(Collectors.toList());
		for(PhoneContact c : contactsOrderedByDate) {
			lastContactsAdded.add(c);
		}
	}
	
	public void loadMessages(Deque<Message> receivedMessages) {
		List<Message> messages = database.recoverMessageData();
		MessageComparator cmp = new MessageComparator();
		List<Message> messagesOrderedByDate = messages.stream().sorted((a, b) -> cmp.compare(a, b)).collect(Collectors.toList());
		for(Message m : messagesOrderedByDate) {
			receivedMessages.add(m);
		}
	}
}
