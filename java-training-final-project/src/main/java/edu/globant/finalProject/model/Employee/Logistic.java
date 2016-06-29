package edu.globant.finalProject.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;

import edu.globant.finalProject.model.Inventory.Inventory;

public class Logistic extends Employee{
	
	public Logistic(String name) {
		super(name);
	}

	@Autowired
	private Inventory inventory;
	

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
}
