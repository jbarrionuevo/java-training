package edu.globant.service;

import edu.globant.domain.Provider;

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
