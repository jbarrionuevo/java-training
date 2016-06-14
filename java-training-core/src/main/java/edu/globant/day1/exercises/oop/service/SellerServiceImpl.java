package edu.globant.day1.exercises.oop.service;

import java.util.Set;

import edu.globant.day1.exercises.oop.dao.SellerDao;
import edu.globant.day1.exercises.oop.model.Sale;
import edu.globant.day1.exercises.oop.model.Seller;

public class SellerServiceImpl implements SellerService {
	
	SellerDao dao;

	@Override
	public Seller getSeller(int id) {	
		return dao.getSeller(id);
	}

	@Override
	public void saveSeller(Seller seller) {
		dao.saveSeller(seller);		
	}

	@Override
	public void updateSeller(Seller seller) {
		Seller entity = dao.getSeller(seller.getId());
		if(entity!=null){
			entity.setFirstName(seller.getFirstName());
			entity.setLastName(seller.getLastName());
			entity.setSellerType(seller.getSellerType());
		}
	}

	@Override
	public void deleteSeller(Seller seller) {
		dao.deleteSeller(seller);
		
	}

	@Override
	public Sale getSale(int id) {
		return dao.getSale(id);
	}

	@Override
	public void saveSale(Sale sale) {
		//Validates that the sale is possible (e.g. checks if there are enough cases in stock)
		//If the sale is PAID, decreases the stock. If it gets below the minium, 
		//it creates an alert for the logistic employees.
		dao.saveSale(sale);
		
	}

	@Override
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

	@Override
	public void deleteSale(Sale sale) {
		dao.deleteSale(sale);		
	}

	@Override
	public Set<Sale> getAllSales() {
		return dao.getAllSales();
	}

	@Override
	public Set<Sale> getSalesBySeller(int id) {
		return dao.getSalesBySeller(id);
	}

	@Override
	public Set<Sale> getSalesByCustomer(int id) {
		return dao.getSalesByCustomer(id);
	}

}
