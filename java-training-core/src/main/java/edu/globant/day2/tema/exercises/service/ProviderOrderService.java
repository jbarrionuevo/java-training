package edu.globant.day2.tema.exercises.service;

import edu.globant.day2.tema.exercises.model.Provider;

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
