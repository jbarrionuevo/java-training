package edu.globant.day1.layerandtiers.exercices.IONSolid.model.services.managers;

import edu.globant.day1.layerandtiers.exercices.IONSolid.model.WarehouseInventory;

public class WarehouseManager {

	private WarehouseInventory inventory;
	
	public WarehouseManager() {
		inventory = WarehouseInventory.getInstance();
	}
}
