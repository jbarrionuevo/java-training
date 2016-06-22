package edu.globant.day3.multithreading.exercises;

public class Deposit implements TypeOfTask{

	@Override
	public Runnable execute(String name) {
		Thread deposit = new Thread(() -> {
			System.out.println(this.toString() + name);
			try {
				Thread.sleep(2000);
				System.out.println("Deposit of "+name+" finished!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		return deposit;
	}
	
	public String toString(){
		return "Doing a deposit, I'm: ";
	}

}
