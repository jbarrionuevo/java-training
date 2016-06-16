package edu.globant.day1.designpatterns.IONSolid.services.managers;

import edu.globant.day1.designpatterns.IONSolid.model.WarehouseInventory;

public class WarehouseManager {

	private WarehouseInventory inventory;
	
	public WarehouseManager() {
		inventory = WarehouseInventory.getInstance();
	}
}
