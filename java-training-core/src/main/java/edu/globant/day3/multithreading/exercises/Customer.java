package edu.globant.day3.multithreading.exercises;

public class Customer {
	private int accNumber;
	private String name;
	private String operation;

	public Customer(String name, String operation, int accNumber) {
		this.accNumber = accNumber;
		this.name = name;
		this.operation = operation;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public int getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(int accNumber) {
		this.accNumber = accNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void operation() {
		switch (this.getOperation()) {
		case "borrow":
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "check":
			try {
				Thread.sleep(300);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "deposit":
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		}
	}

	public void borrow() {
		try {
			Thread.sleep(1500);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deposit() {
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void check() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return String.format(this.getName());
	}

}
