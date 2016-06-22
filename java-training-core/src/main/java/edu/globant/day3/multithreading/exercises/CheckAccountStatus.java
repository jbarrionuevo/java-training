package edu.globant.day3.multithreading.exercises;

public class CheckAccountStatus implements TypeOfTask{

	@Override
	public Runnable execute(String name) {
		Thread checkAccountStatus = new Thread(() -> {
			System.out.println(this.toString() + name);
			try {
				Thread.sleep(3000);
				System.out.println("Checking account status of "+name+" finished!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		return checkAccountStatus;
	}
	
	public String toString(){
		return "Doing a checkAccountStatus, I'm: ";
	}

}
