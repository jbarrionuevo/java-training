package edu.globant.day1.oop.exercices.services;

import edu.globant.day1.oop.exercices.daos.SaleDao;
import edu.globant.day1.oop.exercices.enums.SaleStatus;
import edu.globant.day1.oop.exercices.models.Sale;

public class SaleService {
	
	private SaleDao saleDao;

	public void registerSale(Sale sale){
		System.out.println("Saving sale");
		//saleDao.save(sale);
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
	
}
