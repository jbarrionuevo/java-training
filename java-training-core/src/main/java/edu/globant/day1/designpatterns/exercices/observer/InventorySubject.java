package edu.globant.day1.designpatterns.exercices.observer;

import edu.globant.day1.oop.exercices.models.Case;

public interface InventorySubject {

		public void addObserver(InventoryObserver inventoryObserver);

		public void removeObserver(InventoryObserver inventoryObserver);

		public void doNotify(Case aCase);

}
