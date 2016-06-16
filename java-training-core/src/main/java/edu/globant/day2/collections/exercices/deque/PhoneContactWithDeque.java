package edu.globant.day2.collections.exercices.deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

import edu.globant.day2.collections.exercices.list.PhoneContact;

public class PhoneContactWithDeque {
	public static void main(String[] args) {
		ArrayDeque<PhoneContact> phoneBook = new ArrayDeque<PhoneContact>();
		System.out.println("Adding as a queue");
		phoneBook.offer(new PhoneContact("ilan", "rosenfeld", "1234567"));
		phoneBook.offer(new PhoneContact("john", "coltraine", "7654321"));
		phoneBook.offer(new PhoneContact("miles", "davis", "3456712"));
		System.out.println(phoneBook);
		System.out.println(phoneBook.peekLast());
		System.out.println(phoneBook.pollLast());
		System.out.println(phoneBook);
		System.out.println("Adding as a stack");
		phoneBook.push(new PhoneContact("charlie", "parker", "2345671"));
		phoneBook.push(new PhoneContact("dexter", "gordon", "5671234"));
		System.out.println(phoneBook);
		System.out.println(phoneBook.peekFirst());
		System.out.println(phoneBook.pollFirst());
		System.out.println(phoneBook);
	}

}
