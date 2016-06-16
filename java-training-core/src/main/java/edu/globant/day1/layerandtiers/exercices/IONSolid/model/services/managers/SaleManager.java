package edu.globant.day1.layerandtiers.exercices.IONSolid.model.services.managers;

import edu.globant.day1.layerandtiers.exercices.IONSolid.model.employee.SaleEmployee;
import edu.globant.day1.layerandtiers.exercices.IONSolid.model.receipt.Receipt;

public class SaleManager {

	private WarehouseManager warehouse;
	
	public SaleManager(WarehouseManager warehouse) {
		this.warehouse = warehouse;
	}
	
	public void registerASale(SaleEmployee emp, Receipt receipt) {
		emp.sell(receipt);
	}
}
