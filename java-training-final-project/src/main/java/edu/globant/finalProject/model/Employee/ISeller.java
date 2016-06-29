package edu.globant.finalProject.model.Employee;

import edu.globant.finalProject.model.Sale.Sale;


public interface ISeller {
	void registerAllSales();
	void registerSale(Sale s);
}
