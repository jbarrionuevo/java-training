package exercices.day6.dependency_injection;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

public class Logistic extends Employee {
	
	private Inventory inventory;
	
	public Logistic(String name, Inventory inventory) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
	


}
