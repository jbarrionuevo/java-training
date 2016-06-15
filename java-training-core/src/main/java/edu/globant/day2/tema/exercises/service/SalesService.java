package edu.globant.day2.tema.exercises.service;

import edu.globant.day2.tema.exercises.model.Employee;

public class SalesService {
	private InventoryService inventoryService;

	public SalesService(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}

	public void processSell() {
		this.inventoryService.update();
	}

	public void cancelSell() {
		this.inventoryService.update();
	}

	public void draftSell() {
		this.inventoryService.update();
	}

	public void refundSell() {
		this.inventoryService.update();
	}

	public void registerSell(Employee seller) {

	}
}
