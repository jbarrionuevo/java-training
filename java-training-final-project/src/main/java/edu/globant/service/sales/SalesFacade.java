package edu.globant.service.sales;

import edu.globant.service.InventoryService;

//mi idea is to use this pattern to abstract the use of multiple sales services to the view
public class SalesFacade {
	private InventoryService inventoryService;
	private SalesService salesService;

	public SalesFacade() {
		inventoryService = InventoryService.getInstance();
		salesService = new SalesService(inventoryService);
	}

	public void cancelSale() {
		salesService.cancelSell();
	}
}