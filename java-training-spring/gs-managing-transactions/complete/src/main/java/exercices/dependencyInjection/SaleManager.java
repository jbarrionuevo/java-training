package exercices.dependencyInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleManager {

	private WarehouseManager warehouseManager;
	
	@Autowired
	public SaleManager(WarehouseManager warehouse) {
		this.warehouseManager = warehouse;
	}
	
	public Sale registerASale(Sale sale) {
		
		System.out.println("Logic for register a Sale");
		this.warehouseManager.checkInventory();
		return sale;
	}
}
