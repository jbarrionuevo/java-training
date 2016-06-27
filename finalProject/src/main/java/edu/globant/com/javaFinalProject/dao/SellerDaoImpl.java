package edu.globant.com.javaFinalProject.dao;

import java.util.Set;

import edu.globant.com.javaFinalProject.model.Sale;
import edu.globant.com.javaFinalProject.model.Seller;

public class SellerDaoImpl implements SellerDao {

	public Seller getSeller(int id) {
		// Returns a seller from the DB based on the Id
		return null;
	}

	public void saveSeller(Seller seller) {
		// Persists a seller in the DB
	}

	public void deleteSeller(Seller seller) {
		// Deletes a seller from the DB		
	}

	public Sale getSale(int id) {
		// Gets a single sale from the DB based on the Id
		return null;
	}

	public void saveSale(Sale sale) {
		// Persists a sale in the DB
		
	}

	public void deleteSale(Sale sale) {
		// Deletes a sale from the DB
		
	}

	public Set<Sale> getAllSales() {
		// Gets all sales from the DB
		return null;
	}

	public Set<Sale> getSalesBySeller(int id) {
		// Gets all sales of a specified seller
		return null;
	}

	public Set<Sale> getSalesByCustomer(int id) {
		// Gets all sales based on a specific customer
		return null;
	}

}
