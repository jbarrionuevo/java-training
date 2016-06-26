package service;

import domain.Provider;

public class ProviderOrderService {
	@SuppressWarnings("unused")
	private InventoryService inventoryService;

	public ProviderOrderService(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}

	public void registerOrderToProvider(Provider provider) {
	}

	public void verifyAmountOfCases() {
	}
}
