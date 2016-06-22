package edu.globant.day3.multithreading.exercises;

public class Borrowal implements TypeOfTask{

	@Override
	public Runnable execute(String name) {
		Thread borrowal = new Thread(() -> {
			System.out.println(this.toString() + name);
			try {
				Thread.sleep(5000);
				System.out.println("Borrowal of "+name+" finished!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		return borrowal;
	}
	
	public String toString(){
		return "Doing a borrowal, I'm: ";
	}

}
