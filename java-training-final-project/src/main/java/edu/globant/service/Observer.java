package edu.globant.service;

public abstract class Observer {
	protected InventoryService inventoryService;

	public abstract void update();
}