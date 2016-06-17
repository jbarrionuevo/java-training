package edu.globant.day3.multithreading.exercices;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

public class BankingCenter {
	
	public static void main(String[] args) throws InterruptedException {
		
		Queue<Customer> queue = new LinkedList<Customer>();
		
		Random random = new Random();
		int numberOfTellers = random.nextInt(4)+1;
		
		Thread enqueuer = new Thread(() -> {
			int i=1;
			while(true){
				try {
					Thread.sleep((random.nextInt(4)+1)*200);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(!(queue.size()>5)){  //WE ESTABLISH THAT THE MAXIMUM OF CUSTOMERS THAT CAN BE WAITING IS 5
					int nextRandom = random.nextInt(3)+1;
					String typeOfCustomer = "check";
					switch(nextRandom){
						case 1:
							typeOfCustomer="borrow";
							break;
						case 2:
							typeOfCustomer="deposit";
							break;
						default:
							break;
					}
					queue.offer(new Customer(String.valueOf(i),typeOfCustomer));
					System.out.println("Client "+String.valueOf(i)+" is now at the queue, wanting to "+typeOfCustomer);
					i++;
				} else System.out.println("Clients outside waiting the queue to be smaller so they can enter it!!"+queue);
			}
		});
		
		for (int i = 0; i < numberOfTellers; i++) {
			Thread teller = new Thread(() -> {
				Customer nextToAttend;
				while(true){
					nextToAttend=null;
					synchronized (queue) {
						if(queue.size()>0){
							nextToAttend = queue.poll();
						}
					}
					if(nextToAttend!=null){
						System.out.println(String.format(Thread.currentThread().getName()+" attending client "+nextToAttend.getName()+", "
								+ "who wants to "+nextToAttend.getBankAction()));
						nextToAttend.makeAction();
					}
						
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}, "Teller no "+(i+1));
			tellers.add(teller);
		}
		System.out.println("Opening bank");
		tellers.stream().forEach(t->{
			t.setDaemon(true);
			t.start();
		});
		enqueuer.setDaemon(true);
		enqueuer.start();
		Thread.sleep(20000);
		System.out.println("Bank Closed");
	}

	
}
