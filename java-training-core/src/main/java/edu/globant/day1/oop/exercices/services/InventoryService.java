package edu.globant.day1.oop.exercices.services;

import java.util.HashMap;

import edu.globant.day1.oop.exercices.daos.InventoryDao;
import edu.globant.day1.oop.exercices.models.Case;
import edu.globant.day1.oop.exercices.models.CaseDesign;
import edu.globant.day1.oop.exercices.models.CaseDevice;
import edu.globant.day1.oop.exercices.models.Inventory;
import edu.globant.day1.oop.exercices.models.Provider;

public class InventoryService {
	
	private InventoryDao inventoryDao;
	
	public void addCase(Case aCase, int quantity){
		HashMap<Case,Integer> inventory = Inventory.getInventory();
		inventory.put(aCase, inventory.get(aCase)+quantity);
		//update inventory in db
	}
	
	public void removeCase(Case aCase, int quantity){
		HashMap<Case,Integer> inventory = Inventory.getInventory();
		inventory.put(aCase, inventory.get(aCase)-quantity);
		//trigger alarm if the case stock is less than a minimum number
		//update inventory in db
	}
	
	public int caseStock(CaseDesign design, CaseDevice device){
		System.out.println("return the number of cases with those parameters");
		return 0;
	}
	
	public void incrementStock(CaseDesign design, CaseDevice device, int quantity){
		System.out.println("update stock for cases with those parameters");
	}
	
	public void decrementStock(CaseDesign design, CaseDevice device, int quantity){
		System.out.println("update stock for cases with those parameters");
	}
	
	public int caseAmountFromProvider(Provider provider){
		System.out.println("return the number of cases provided by a specific provider");
		return 0;
	}

	public InventoryDao getInventoryDao() {
		return inventoryDao;
	}

	public void setInventoryDao(InventoryDao inventoryDao) {
		this.inventoryDao = inventoryDao;
	}
}
