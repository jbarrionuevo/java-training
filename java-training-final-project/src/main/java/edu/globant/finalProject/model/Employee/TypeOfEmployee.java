package edu.globant.finalProject.model.Employee;

import edu.globant.finalProject.model.Sale.Sale;


public interface TypeOfEmployee {
	
	default public void registerAllSales(){}

	default public void registerSale(Sale s) {
		System.out.println("Registering sale...");
	}
}
