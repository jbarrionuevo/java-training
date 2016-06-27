package edu.globant.com.javaFinalProject.dao;

import java.util.Set;

import edu.globant.com.javaFinalProject.model.Sale;
import edu.globant.com.javaFinalProject.model.Seller;


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
