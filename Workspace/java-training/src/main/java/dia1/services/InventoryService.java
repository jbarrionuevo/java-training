package dia1.services;

import java.util.HashMap;

import dia1.daos.InventoryDao;
import dia1.models.Case;
import dia1.models.CaseDesign;
import dia1.models.CaseDevice;
import dia1.models.Inventory;
import dia1.models.Provider;

public class InventoryService {
	
	private InventoryDao inventoryDao;
	
	public void addCaseToInventory(Case aCase, int quantity){
		HashMap<Case,Integer> inventory = Inventory.getInventory();
		inventory.put(aCase, inventory.get(aCase)+quantity);
		//update inventory in db
	}
	
	public void removeCaseFromInventory(Case aCase, int quantity){
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
