package edu.globant.IONSolid.model.employee;

import edu.globant.IONSolid.model.receipt.Receipt;

public class SaleEmployee extends Employee {

	public SaleEmployee(String name, String lastName, int age, boolean gender, String adress) {
		super(name, lastName, age, gender, adress);
	}
	
	public void sell(Receipt sale) {
		
	}
}