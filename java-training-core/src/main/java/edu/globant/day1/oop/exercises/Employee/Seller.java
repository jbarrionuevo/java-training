package edu.globant.day1.oop.exercises.Employee;

import java.util.ArrayList;

import edu.globant.day1.oop.exercises.Sale.Sale;

public class Seller implements TypeOfEmployee{
	private ArrayList<Sale> sales;
	
	private void registerAllSales(){
		sales.forEach(s -> s.register());
	}
	
	private void registerSale(Sale s){
		s.register();
	}
}
