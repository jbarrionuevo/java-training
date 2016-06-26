package service;

import service.sales.SalesService;

//mi idea is to use this pattern to abstract the use of multiple services to the view
public class FacadeService {
	private InventoryService inventoryService;
	private ProviderOrderService providerOrderService;
	private SalesService salesService;

	public FacadeService() {
		inventoryService = InventoryService.getInstance();
		providerOrderService = new ProviderOrderService(inventoryService);
		salesService = new SalesService(inventoryService);
	}

	public void cancellSale() {
		salesService.cancelSell();
	}

	public void registerOrderToProvider() {
		providerOrderService.registerOrderToProvider(null);
	}
}