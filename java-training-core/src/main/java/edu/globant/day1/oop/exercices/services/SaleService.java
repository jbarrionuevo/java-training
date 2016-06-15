package edu.globant.day1.oop.exercices.services;

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

	public void registerSale(Sale sale){
		System.out.println("Saving sale");
		//saleDao.save(sale);
		//decrement inventory amount for sale case and quantity
		HashMap<Case,Integer> inventory = Inventory.getInventory();
		//for each case/integer in sale, update inventory
		//update inventory in db
		//trigger alarm if the case stock is less than a minimum number
	}
	
	public void cancelSale(Sale sale){
		sale.setStatus(SaleStatus.CANCELLED);
		System.out.println("Cancelling sale");
		//update sale in db
	}
	
	public void markAsPaid(Sale sale){
		System.out.println("Paying sale");
		sale.setStatus(SaleStatus.PAID);
		//update sale in db
	}
	
	public void refundSale(Sale sale){
		System.out.println("Refund sale");
		sale.setStatus(SaleStatus.REFUND);
		//update sale in db
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
