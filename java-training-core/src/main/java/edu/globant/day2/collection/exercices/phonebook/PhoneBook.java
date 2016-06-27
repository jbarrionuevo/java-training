package edu.globant.day2.collection.exercices.phonebook;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

import edu.globant.day2.collection.exercices.phonebook.dataaccess.DataBaseAccess;
import edu.globant.day2.collection.exercices.phonebook.message.Message;
import edu.globant.day2.collection.exercices.phonebook.phonecontact.PhoneContact;
import edu.globant.day2.collection.exercices.phonebook.phonecontact.comparator.PhoneContactDateComparator;
import edu.globant.day2.collection.exercices.phonebook.phonecontact.comparator.PhoneContactNameComparator;

public class PhoneBook {

	private Set<PhoneContact> phoneBook;
	private Map<String, List<PhoneContact>> groups;
	private Queue<PhoneContact> lastContactsAdded;
	private Deque<Message> receivedMessages;
	private PhoneBookDataLoader dataLoader;
	
	public PhoneBook() {
		phoneBook = new TreeSet<PhoneContact>(new PhoneContactNameComparator());
		lastContactsAdded = new PriorityQueue<PhoneContact>(new PhoneContactDateComparator());
		groups = new HashMap<String, List<PhoneContact>>();
		receivedMessages = new LinkedList<Message>();
		dataLoader = new PhoneBookDataLoader(new DataBaseAccess());
		this.loadData();
	}
	
	private void loadData() {
		dataLoader.loadPhoneBook(phoneBook);
		dataLoader.loadLastContactsAdded(lastContactsAdded);
		dataLoader.loadMessages(receivedMessages);
	}
	
	public Set<PhoneContact> getContacts() {
		return phoneBook;
	}
	
	public Queue<PhoneContact> getLastContactsAdded() {
		return lastContactsAdded;
	}
	
	public List<Message> getMessagesByDate() {
		Deque<Message> tmp = new LinkedList<Message>();
		List<Message> list = new ArrayList<Message>();
		
		while(!receivedMessages.isEmpty()) {
			Message m = receivedMessages.pollFirst();
			list.add(m);
			tmp.addLast(m);
		}
		receivedMessages = tmp;
		
		return list;
	}
	
	public List<Message> getLastMessagesFirst() {
		Deque<Message> tmp = new LinkedList<Message>();
		List<Message> list = new ArrayList<Message>();
		
		while(!receivedMessages.isEmpty()) {
			Message m = receivedMessages.pollLast();
			list.add(m);
			tmp.addFirst(m);
		}
		receivedMessages = tmp;
		
		return list;
	}
	
	public PhoneContact getContact(String name) {
		for(PhoneContact c : phoneBook) {
			if(name.equals(c.getContactName())) {
				return c;
			}
		}
		return null;
	}
	
	public void addContactToGroup(String group, PhoneContact contact) {
		if(!this.groups.containsKey(group)) {
			List<PhoneContact> groupList = new ArrayList<PhoneContact>();
			groupList.add(contact);
			this.groups.put(group, groupList);
		} 
		else {
			List<PhoneContact> groupList = this.groups.get(group);
			groupList.add(contact);
			this.groups.put(group, groupList);
		}
	}
	
	public Map<String, List<PhoneContact>> getGroups() {
		return this.groups;
	}
	

}
