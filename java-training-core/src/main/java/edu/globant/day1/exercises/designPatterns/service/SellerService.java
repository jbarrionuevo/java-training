package edu.globant.day1.exercises.designPatterns.service;

import java.util.Set;

import edu.globant.day1.exercises.oop.model.Sale;
import edu.globant.day1.exercises.oop.model.Seller;

public interface SellerService {
	
	Seller getSeller(int id);
	void saveSeller(Seller seller);
	void updateSeller(Seller seller);
	void deleteSeller(Seller seller);
	Sale getSale(int id);
	void saveSale(Sale sale);
	void updateSale(Sale sale);
	void deleteSale(Sale sale);
	Set<Sale> getAllSales();
	Set<Sale> getSalesBySeller(int id);
	Set<Sale> getSalesByCustomer(int id);
	
}
