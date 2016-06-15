package edu.globant.day2.tema.exercises.service;

public abstract class Observer {
	protected InventoryService inventoryService;

	public abstract void update();
}