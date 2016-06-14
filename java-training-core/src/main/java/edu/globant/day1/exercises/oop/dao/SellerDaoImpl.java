package edu.globant.day1.exercises.oop.dao;

import java.util.Set;

import edu.globant.day1.exercises.oop.model.Sale;
import edu.globant.day1.exercises.oop.model.Seller;

public class SellerDaoImpl implements SellerDao {

	@Override
	public Seller getSeller(int id) {
		// Returns a seller from the DB based on the Id
		return null;
	}

	@Override
	public void saveSeller(Seller seller) {
		// Persists a seller in the DB
	}

	@Override
	public void deleteSeller(Seller seller) {
		// Deletes a seller from the DB		
	}

	@Override
	public Sale getSale(int id) {
		// Gets a single sale from the DB based on the Id
		return null;
	}

	@Override
	public void saveSale(Sale sale) {
		// Persists a sale in the DB
		
	}

	@Override
	public void deleteSale(Sale sale) {
		// Deletes a sale from the DB
		
	}

	@Override
	public Set<Sale> getAllSales() {
		// Gets all sales from the DB
		return null;
	}

	@Override
	public Set<Sale> getSalesBySeller(int id) {
		// Gets all sales of a specified seller
		return null;
	}

	@Override
	public Set<Sale> getSalesByCustomer(int id) {
		// Gets all sales based on a specific customer
		return null;
	}

}
