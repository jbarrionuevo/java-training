package exercices.dependencyInjection;

import org.springframework.stereotype.Service;

@Service
public class WarehouseManager {

	public WarehouseManager() {
		
	}
	
	public void checkInventory() {
		System.out.println("I am checking for Inventory.... ");
	}
	
}
