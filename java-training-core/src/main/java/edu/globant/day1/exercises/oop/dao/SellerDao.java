package edu.globant.day1.exercises.oop.dao;

import java.util.Set;

import edu.globant.day1.exercises.oop.model.Sale;
import edu.globant.day1.exercises.oop.model.Seller;

public interface SellerDao {

	Seller getSeller(int id);
	void saveSeller(Seller seller);
	void deleteSeller(Seller seller);
	Sale getSale(int id);
	void saveSale(Sale sale);
	void deleteSale(Sale sale);
	Set<Sale> getAllSales();
	Set<Sale> getSalesBySeller(int id);
	Set<Sale> getSalesByCustomer(int id);
	
}
