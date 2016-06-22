package service;

public class InventoryObserver extends Observer {

	public InventoryObserver(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
		this.inventoryService.attach(this);
	}

	@Override
	public void update() {

	}
}