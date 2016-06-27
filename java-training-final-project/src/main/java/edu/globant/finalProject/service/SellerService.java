package edu.globant.finalProject.service;

import java.util.ArrayList;

import edu.globant.finalProject.model.Case.Case;
import edu.globant.finalProject.model.Customer.Customer;
import edu.globant.finalProject.model.Sale.Sale;

public interface SellerService {
	public void registerSale(Sale sale);
	public void registerAllSales(ArrayList<Sale> sales);
}
