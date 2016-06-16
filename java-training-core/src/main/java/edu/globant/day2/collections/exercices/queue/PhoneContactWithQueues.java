package edu.globant.day2.collections.exercices.queue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import edu.globant.day2.collections.exercices.list.PhoneContact;

public class PhoneContactWithQueues {
	public static void main(String[] args) {
		PriorityQueue<PhoneContact> phoneBook = (PriorityQueue<PhoneContact>) addNumbers(new PriorityQueue<PhoneContact>());
		System.out.println(phoneBook);
		System.out.println("We'll see that the priority queue order the items authomatically by ascending lastname");
		System.out.println(phoneBook.peek());
		System.out.println(phoneBook.poll());
		System.out.println(phoneBook.peek());
		System.out.println(phoneBook.poll());
		System.out.println(phoneBook.poll());
		System.out.println(phoneBook.poll());
		System.out.println(phoneBook);
	}

	public static Queue<PhoneContact> addNumbers(Queue<PhoneContact> queue) {
		queue.offer(new PhoneContact("ilan", "rosenfeld", "1234567"));
		queue.offer(new PhoneContact("john", "coltraine", "7654321"));
		queue.offer(new PhoneContact("miles", "davis", "3456712"));
		queue.offer(new PhoneContact("charlie", "parker", "2345671"));
		queue.offer(new PhoneContact("dexter", "gordon", "5671234"));
		return queue;
	}
}
