package edu.globant.finalproject.model.Employee;

import java.util.ArrayList;

import edu.globant.finalproject.model.Sale.SaleDTO;



public class SellerDTO extends EmployeeDTO{
	
	public SellerDTO(String name) {
		super(name);
	}

	private ArrayList<SaleDTO> sales;
	
	public ArrayList<SaleDTO> getSales() {
		return sales;
	}
	
	public void setSales(ArrayList<SaleDTO> sales) {
		this.sales = sales;
	}
}
