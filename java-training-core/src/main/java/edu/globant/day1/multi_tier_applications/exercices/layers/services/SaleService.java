package edu.globant.day1.multi_tier_applications.exercices.layers.services;

import java.util.HashMap;

import edu.globant.day1.oop.exercices.daos.InventoryDao;
import edu.globant.day1.oop.exercices.daos.SaleDao;
import edu.globant.day1.oop.exercices.enums.SaleStatus;
import edu.globant.day1.oop.exercices.models.Case;
import edu.globant.day1.oop.exercices.models.Inventory;
import edu.globant.day1.oop.exercices.models.Sale;

public class SaleService {
	
	private SaleDao saleDao;
	private InventoryDao inventoryDao;

	
	public SaleDao getSaleDao() {
		return saleDao;
	}

	public void setSaleDao(SaleDao saleDao) {
		this.saleDao = saleDao;
	}

	public InventoryDao getInventoryDao() {
		return inventoryDao;
	}

	public void setInventoryDao(InventoryDao inventoryDao) {
		this.inventoryDao = inventoryDao;
	}
	
}
