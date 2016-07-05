package edu.globant.finalproject.model.Employee;

import edu.globant.finalproject.model.Sale.SaleDTO;

public interface ISeller {
	void registerAllSales();
	void registerSale(SaleDTO s);
}
