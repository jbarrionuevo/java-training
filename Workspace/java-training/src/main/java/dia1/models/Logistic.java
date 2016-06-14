package dia1.models;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

public class Logistic extends Employee {
	
	private HashMap<Case, Integer> inventory;
	
	public HashMap<Case, Integer> getInventory() {
		return inventory;
	}

	public void setInventory(HashMap<Case, Integer> inventory) {
		this.inventory = inventory;
	}
	
	public void addCaseToInventory(Case aCase, int quantity){
		this.inventory.put(aCase, this.inventory.get(aCase)+quantity);
	}
	
	public void removeCaseFromInventory(Case aCase, int quantity){
		this.inventory.put(aCase, this.inventory.get(aCase)-quantity);
	}

}
