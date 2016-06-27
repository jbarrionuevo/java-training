package edu.globant.com.javaFinalProject.service;

import java.util.Set;

import edu.globant.com.javaFinalProject.model.Sale;
import edu.globant.com.javaFinalProject.model.Seller;

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
