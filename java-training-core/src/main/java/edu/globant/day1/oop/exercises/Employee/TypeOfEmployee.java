package edu.globant.day1.oop.exercises.Employee;

import edu.globant.day1.oop.exercises.Sale.Sale;

public interface TypeOfEmployee {
	
	default public void registerAllSales(){}

	default public void registerSale(Sale s) {
		System.out.println("Registering sale...");
	}
}
