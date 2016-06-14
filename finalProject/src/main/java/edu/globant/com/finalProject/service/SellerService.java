package edu.globant.com.finalProject.service;

import java.util.Set;

import edu.globant.com.finalProject.model.Sale;
import edu.globant.com.finalProject.model.Seller;

public interface SellerService {
	
	Seller getSeller(int id);
	void saveSeller(Seller seller);
	void saveSell(Sale sell);
	Set<Sale> getSellerSales(int id);
	
}
