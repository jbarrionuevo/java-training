package edu.globant.day2.collections.exercises.phoneapp;

import java.util.PriorityQueue;

public class PhoneContactQueue {

	public static void main(String[] args) {
		PriorityQueue<PhoneContact> contacts = new PriorityQueue<PhoneContact>();

		PhoneContact c1 = new PhoneContact("11111", "aname");
		PhoneContact c2 = new PhoneContact("33333", "cname");
		PhoneContact c3 = new PhoneContact("22222", "bname");
		PhoneContact c4 = new PhoneContact("44444", "bname");

		contacts.offer(c3);
		contacts.offer(c1);
		contacts.offer(c2);
		contacts.offer(c4);

		System.out.println("Queue first element");
		System.out.println(contacts.peek());

		System.out.println("Printing queue");
		System.out.println(contacts);

		System.out.println("Printing contacts amount");
		System.out.println(contacts.size());

		System.out.println("Printing queue first to remove");
		System.out.println(contacts.poll());

		System.out.println("Printing with first removed");
		System.out.println(contacts);

		System.out.println("Printing contacts amount");
		System.out.println(contacts.size());

	}

}
