package edu.globant.day1.multi_tier_applications.exercices.layers.services;

import java.util.HashMap;

import edu.globant.day1.oop.exercices.daos.InventoryDao;
import edu.globant.day1.oop.exercices.models.Case;
import edu.globant.day1.oop.exercices.models.CaseDesign;
import edu.globant.day1.oop.exercices.models.CaseDevice;
import edu.globant.day1.oop.exercices.models.Inventory;
import edu.globant.day1.oop.exercices.models.Provider;

public class InventoryService {
	
	private InventoryDao inventoryDao;

	public InventoryDao getInventoryDao() {
		return inventoryDao;
	}

	public void setInventoryDao(InventoryDao inventoryDao) {
		this.inventoryDao = inventoryDao;
	}
}