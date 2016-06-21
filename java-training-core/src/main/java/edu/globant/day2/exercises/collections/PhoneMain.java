package edu.globant.day2.exercises.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PhoneMain {
	
	static List<Contact> contactList = new ArrayList<Contact>();
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int choice;
		int phoneNumbers;
			
		for(int i = 0; i<100; i++){
			List<String> contactNumbers = new ArrayList<String>();
			Contact contact = new Contact();
			contact.setFirstName("First Name "+ (int) Math.ceil(Math.random() * 100));
			contact.setLastName("Last Name " + (int) Math.ceil(Math.random() * 100));
			phoneNumbers = (int) Math.ceil(Math.random() * 3);
			for(int f = 0; f<phoneNumbers; f++){
				String phoneNumber = new String();
				for(int h = 0; h<8;h++){
					phoneNumber += (int) Math.ceil(Math.random() * 9);
					if(h == 3){
						phoneNumber += "-";
					}
				}
				
				contactNumbers.add(phoneNumber);
			}
			contact.setPhoneNumbers(contactNumbers);
			contactList.add(contact);
			
			
		}
		
		showOptions();
	
	}
	
	public static void showOptions(){
		Scanner scan = new Scanner(System.in);
		int choice;
		System.out.println("Welcome. Please choose your option");
		System.out.println("1) View all contacts\n2) View recent calls\n3) Search by name\n4) Sort by name\n5) Remove duplicates");
		choice = scan.nextInt();
		doThings(choice);
		
	}
	
	public static void doThings(int choice){
	
		switch(choice){
			case 1: 
				for(Contact contact : contactList){
					System.out.println(contact);
				}
				System.out.println(contactList.size() + " contacts found");
				showOptions();
			break;
			
			case 5:
				Set<Contact> contactsWithoutDuplicates = new TreeSet<Contact>(contactList);
			List<Contact> arrayWithoutDuplicates = new ArrayList<Contact>(contactsWithoutDuplicates);
			contactList = arrayWithoutDuplicates;
			
				for(Contact contact : contactList){
					System.out.println(contact);
				}
				System.out.println(contactList.size() + " contacts found");
				showOptions();
			break;
			default: System.out.println("Error: option not available");
					 showOptions();
			break;
		}
	
	}
	

}
