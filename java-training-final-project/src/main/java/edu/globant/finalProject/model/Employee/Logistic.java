package edu.globant.finalProject.model.Employee;

import edu.globant.finalProject.model.Inventory.Inventory;

public class Logistic implements TypeOfEmployee{
	private Inventory inventory;

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
}
