package edu.globant.day1.layersandtiers.exercises.model;

import java.util.ArrayList;

import edu.globant.day1.oop.exercises.Sale.Sale;

public class Seller implements TypeOfEmployee{
	private ArrayList<Sale> sales;
	
	

	public ArrayList<Sale> getSales() {
		return sales;
	}

	public void setSales(ArrayList<Sale> sales) {
		this.sales = sales;
	}
	
	
}
