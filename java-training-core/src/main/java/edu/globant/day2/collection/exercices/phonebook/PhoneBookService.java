package edu.globant.day2.collection.exercices.phonebook;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import edu.globant.day2.collection.exercices.phonebook.message.Message;
import edu.globant.day2.collection.exercices.phonebook.phonecontact.PhoneContact;

public class PhoneBookService {

	private PhoneBook book;
	
	public PhoneBookService() {
		book = new PhoneBook();
	}
	
	public void showContacts() {
		Set<PhoneContact> contacts = book.getContacts();
		
		for(PhoneContact c : contacts) {
			System.out.println(c.toString());
		}
	}
	
	public void showLastContactsAdded() {
		Queue<PhoneContact> lastContactsAdded = book.getLastContactsAdded();
		Iterator<PhoneContact> itr = lastContactsAdded.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next().toString());
		}
	}
	
	public void showMessagesByDate() {
		List<Message> list = book.getMessagesByDate();
		
		for(Message m : list) {
			System.out.println( m.toString());
		}
	}
	
	public void showLastMessagesFirst() {
		List<Message> list = book.getLastMessagesFirst();
		
		for(Message m : list) {
			System.out.println( m.toString());
		}
	}
	
	public void addContactToGroup(String group, String name) {
		PhoneContact contact = book.getContact(name);
		if(contact != null) {
			book.addContactToGroup(group, contact);
		}
	}
	
	public void showContactsByGroup() {
		Map<String, List<PhoneContact>> map = book.getGroups();
		for (Map.Entry<String, List<PhoneContact>> entry : map.entrySet()) {
		    System.out.println(entry.getKey());
		    entry.getValue().stream().forEach(c -> System.out.println(c.toString()));
		}
	}
}
