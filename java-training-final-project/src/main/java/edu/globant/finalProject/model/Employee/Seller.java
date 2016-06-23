package edu.globant.finalProject.model.Employee;

import java.util.ArrayList;

import edu.globant.finalProject.model.Sale.Sale;


public class Seller implements TypeOfEmployee{
	private ArrayList<Sale> sales;

	@Override
	public void registerAllSales() {
		getSales().forEach(s-> registerSale(s));
	}
	
	public ArrayList<Sale> getSales() {
		return sales;
	}
	
	public void setSales(ArrayList<Sale> sales) {
		this.sales = sales;
	}
}
