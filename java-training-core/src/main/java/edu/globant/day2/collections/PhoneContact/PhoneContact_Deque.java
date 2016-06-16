package edu.globant.day2.collections.PhoneContact;

import java.util.ArrayDeque;

public class PhoneContact_Deque {
	
	public static void main(String[] args) {
		ArrayDeque<PhoneContact> phones = new ArrayDeque<PhoneContact>();
		
		System.out.println("Adding as a stack");
		phones.push(new PhoneContact("eze", "lopez", "988898"));
		phones.push(new PhoneContact("jacinto", "ad", "6558"));
		phones.push(new PhoneContact("erea", "afa", "989986464"));
		
		System.out.println(phones);
		System.out.println("pollFirst: "+phones.pollFirst());
		System.out.println("pollLast: "+phones.pollLast());
		System.out.println(phones);
		
		System.out.println("Adding as a queue");
		phones.offer(new PhoneContact("dante", "salamone", "123123"));
		phones.offer(new PhoneContact("pepe", "pipon", "1213131313141"));
		phones.offer(new PhoneContact("john", "yuta", "66266"));
		
		System.out.println(phones);
		System.out.println("pollLast: "+phones.pollLast());
		System.out.println("peekLast: "+phones.peekLast());
		System.out.println(phones);
		
		
	}
	
}
