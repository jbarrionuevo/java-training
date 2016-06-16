package edu.globant.day2.collections.exercices.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;
import java.util.stream.Collectors;

import edu.globant.day2.collections.exercices.list.PhoneContact;

public class PhoneContactWithMaps {
	public static void main(String[] args) {
		TreeMap<Person,String> phoneBook = addNumbers(new TreeMap<Person,String>());
		System.out.println("Phone Book: ");
		System.out.println(phoneBook);
		System.out.println("Add a new number; its authomatically added in order");
		phoneBook.put(new Person("new", "newLastName"), "4567123");
		System.out.println(phoneBook);
	}
	
	public static TreeMap<Person,String> addNumbers(TreeMap<Person,String> phoneBook){
		phoneBook.put(new Person("ilan", "rosenfeld"), "1234567");
		phoneBook.put(new Person("john", "coltraine"), "7654321");
		phoneBook.put(new Person("miles", "davis"), "3456712");
		phoneBook.put(new Person("charlie", "parker"), "2345671");
		phoneBook.put(new Person("dexter", "gordon"), "5671234");
		return phoneBook;
	}
}
