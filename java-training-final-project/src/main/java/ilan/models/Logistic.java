package ilan.models;

public class Logistic extends Employee {
	
	private Inventory inventory;
	
	public Logistic(String name, Inventory inventory) {
		super(name);
		this.inventory=inventory;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
	


}
