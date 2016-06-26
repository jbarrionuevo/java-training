package exercices.dependencyInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationManager {

	private SaleManager saleManager;
	private WarehouseManager warehouseManager;
	
	@Autowired
	public ApplicationManager(SaleManager saleManager, WarehouseManager warehouseManager) {
		this.warehouseManager = warehouseManager;
		this.saleManager = saleManager;

	}
	
	public Sale registerASale(Sale sale) {
		return this.saleManager.registerASale(sale);
	}
	
	public void checkInventory() {
		this.warehouseManager.checkInventory();
	}

}
