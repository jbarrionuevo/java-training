package edu.globant.com.javaFinalProject.service;

import java.util.Set;

import edu.globant.com.javaFinalProject.dao.SellerDao;
import edu.globant.com.javaFinalProject.model.Sale;
import edu.globant.com.javaFinalProject.model.Seller;

public class SellerServiceImpl implements SellerService {
	
	SellerDao dao;

	public Seller getSeller(int id) {	
		return dao.getSeller(id);
	}

	public void saveSeller(Seller seller) {
		dao.saveSeller(seller);		
	}

	public void updateSeller(Seller seller) {
		Seller entity = dao.getSeller(seller.getId());
		if(entity!=null){
			entity.setFirstName(seller.getFirstName());
			entity.setLastName(seller.getLastName());
			entity.setSellerType(seller.getSellerType());
		}
	}

	public void deleteSeller(Seller seller) {
		dao.deleteSeller(seller);
		
	}

	public Sale getSale(int id) {
		return dao.getSale(id);
	}

	public void saveSale(Sale sale) {
		//Validates that the sale is possible (e.g. checks if there are enough cases in stock)
		//If the sale is PAID, decreases the stock. If it gets below the minium, 
		//it creates an alert for the logistic employees.
		dao.saveSale(sale);
		
	}

	public void updateSale(Sale sale) {
		Sale entity = dao.getSale(sale.getId());
		if(entity!=null){
			//Updates the sale
			//Validates that the sale is possible (e.g. checks if there are enough cases in stock)
			//If the sale changes to PAID, decreases the stock. If it gets below the minium, 
			//it creates an alert for the logistic employees.
			//If the sale state changes to CANCELLED or REFUND, increases the stock.
		}	
	}

	public void deleteSale(Sale sale) {
		dao.deleteSale(sale);		
	}

	public Set<Sale> getAllSales() {
		return dao.getAllSales();
	}

	public Set<Sale> getSalesBySeller(int id) {
		return dao.getSalesBySeller(id);
	}

	public Set<Sale> getSalesByCustomer(int id) {
		return dao.getSalesByCustomer(id);
	}

}
