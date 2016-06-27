package ilan.services;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ilan.daos.InventoryDao;
import ilan.models.CaseProduct;
import ilan.models.CaseDesign;
import ilan.models.CaseDevice;
import ilan.models.Inventory;
import ilan.models.Provider;

@Service
public class InventoryService {
	
	private final static Logger log = LoggerFactory.getLogger(InventoryService.class);

	@Autowired
	private InventoryDao inventoryDao;
	
//	public void addCase(Case aCase, int quantity){
//		Inventory inventory = Inventory.getInstance();
//		inventory.addCase(aCase, quantity);
//		//update inventory in db
//	}
	
//	public void removeCase(Case aCase, int quantity){
//		Inventory inventory = Inventory.getInstance();
//		inventory.removeCase(aCase, quantity);
//		inventory.doNotify(aCase);
//		//trigger alarm if the case stock is less than a minimum number
//		//update inventory in db
//	}
//	
	
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