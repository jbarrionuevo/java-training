package edu.globant.IONSolid.model.employee;

import edu.globant.IONSolid.model.cases.Case;
import edu.globant.IONSolid.model.sale.Sale;

public class SaleEmployee extends Employee {

	public SaleEmployee(String name, String lastName, int age, boolean gender, String adress) {
		super(name, lastName, age, gender, adress);
	}
	
	public void sell(Sale sale, Case caseProduct) {
		
	}
}
