package edu.globant.day2.collection.exercices.phonecontact;

import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class PhoneBook {

	//Tiene un treeSet ordenado por 
	/*
	 * 
	 */
	Set<PhoneContact> phoneBook;
	Map<String, List<PhoneContact>> groups;
	Queue<PhoneContact> lastContactAdded;
	Deque<Message> receiveMessages;
	DataBaseAccess database;
	
	public PhoneBook() {
		database = new DataBaseAccess();
		phoneBook = new TreeSet<PhoneContact>(new PhoneContactNameComparator());
		lastContactAdded = new PriorityQueue<PhoneContact>(new PhoneContactDateComparator());
		groups = new HashMap<String, List<PhoneContact>>();
	}
	
	public void loadData() {
		
	}
}
