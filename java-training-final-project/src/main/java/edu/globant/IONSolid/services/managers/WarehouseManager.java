package edu.globant.IONSolid.services.managers;

import edu.globant.IONSolid.model.WarehouseInventory;

public class WarehouseManager {

	private WarehouseInventory inventory;
	
	public WarehouseManager() {
		inventory = WarehouseInventory.getInstance();
	}
}
