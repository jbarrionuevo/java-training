package edu.globant.day2.exceptions.exercices.services;

import java.util.HashMap;

import edu.globant.day1.oop.exercices.daos.InventoryDao;
import edu.globant.day1.oop.exercices.enums.SaleStatus;
import edu.globant.day1.oop.exercices.models.Case;
import edu.globant.day1.oop.exercices.models.Inventory;
import edu.globant.day2.exceptions.exercices.daos.SaleDao;
import edu.globant.day2.exceptions.exercices.exceptions.SaleNotFoundException;
import edu.globant.day1.oop.exercices.models.Sale;

public class SaleService {
	
	private SaleDao saleDao;
	private InventoryDao inventoryDao;

	public Sale getSale(int saleId){
		Sale result=null;
		try{
			result= saleDao.getSale(saleId);
		}catch(SaleNotFoundException e){
			System.out.println("Sale id was not found");
			e.printStackTrace(System.out);
		}
		return result;
	}
	
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
