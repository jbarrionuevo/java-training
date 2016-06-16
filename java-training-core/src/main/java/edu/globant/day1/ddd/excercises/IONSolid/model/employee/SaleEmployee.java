package edu.globant.day1.ddd.excercises.IONSolid.model.employee;

import edu.globant.day1.oop.exercises.model.cases.Case;
import edu.globant.day1.oop.exercises.model.sale.Sale;

public class SaleEmployee extends Employee {

	public SaleEmployee(String name, String lastName, int age, boolean gender, String adress) {
		super(name, lastName, age, gender, adress);
	}
	
	public void sell(Sale sale, Case caseProduct) {
		
	}
}
