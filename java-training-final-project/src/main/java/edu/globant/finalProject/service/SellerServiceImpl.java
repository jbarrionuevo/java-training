package edu.globant.finalProject.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import edu.globant.finalProject.dao.SellerDAO;
import edu.globant.finalProject.model.Sale.Sale;

public class SellerServiceImpl implements SellerService{
	
	@Autowired
	SellerDAO sellerDAO;

	@Override
	public void registerAllSales(ArrayList<Sale> sales) {
		System.out.println("Registering all sales...");
		sales.forEach(s -> sellerDAO.register(s));
	}

}
