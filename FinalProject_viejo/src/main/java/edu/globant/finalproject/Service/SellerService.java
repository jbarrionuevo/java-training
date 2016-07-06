package edu.globant.finalproject.Service;

import java.util.ArrayList;

import edu.globant.finalproject.model.Sale.SaleDTO;


public interface SellerService {
	public void registerSale(SaleDTO sale);
	public void registerAllSales(ArrayList<SaleDTO> sales);
}
