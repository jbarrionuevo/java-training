package edu.globant.day1.oop.exercices.services;

import java.util.Collection;

import edu.globant.day1.oop.exercices.daos.CaseSellerDao;
import edu.globant.day1.oop.exercices.models.CaseSeller;
import edu.globant.day1.oop.exercices.models.Order;
import edu.globant.day1.oop.exercices.models.Sale;

public class CaseSellerService {
	
	private CaseSellerDao caseSellerDao;

	public void addOrderToSeller(Order order, CaseSeller seller){
		Sale newSale = new Sale(order);
		seller.addSale(newSale);
		System.out.println("Add order to seller "+seller.getName());
		//update seller in db
	}
	
	public Collection<Order> getOrders(CaseSeller seller){
		return (Collection<Order>) seller.getSales().stream().map(sale->sale.getOrder());
	}
	
	public CaseSellerDao getCaseSellerDao() {
		return caseSellerDao;
	}

	public void setCaseSellerDao(CaseSellerDao caseSellerDao) {
		this.caseSellerDao = caseSellerDao;
	}
	
}
