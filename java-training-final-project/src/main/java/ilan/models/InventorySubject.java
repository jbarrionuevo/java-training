package ilan.models;


public interface InventorySubject {

		public void addObserver(InventoryObserver inventoryObserver);

		public void removeObserver(InventoryObserver inventoryObserver);

		public void doNotify(CaseProduct aCase);

}
