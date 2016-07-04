package edu.globant.service;

import java.util.ArrayList;
import java.util.List;

import edu.globant.domain.Case;

public class InventoryService {

	private static InventoryService inventoryService = new InventoryService();

	private InventoryService() {

	};

	public static InventoryService getInstance() {
		return inventoryService;
	}

	// list of observers to be reported when inventory levels go below watermark
	private List<Observer> observers = new ArrayList<Observer>();

	public Integer getStock() {
		return null;
	}

	public Integer getStockByCaseDesign(String caseDesign) {
		return null;
	}

	public Integer getStockByCaseDevice(String caseDevice) {
		return null;
	}

	public void increaseStock(Case case_, int units) {
		notifyAllObservers();
	}

	public void decreaseStock(Case case_, int units) {
		notifyAllObservers();
	}

	public void update() {
		// TODO Auto-generated method stub

	}

	public void notifyAllObservers() {
		for (Observer observer : observers) {
			observer.update();
		}
	}

	public void attach(Observer observer) {
		observers.add(observer);
	}
}
