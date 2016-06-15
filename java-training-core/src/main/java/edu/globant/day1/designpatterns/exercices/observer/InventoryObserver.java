package edu.globant.day1.designpatterns.exercices.observer;

import java.util.Collection;
import java.util.HashMap;

import edu.globant.day1.oop.exercices.models.Case;
import edu.globant.day1.oop.exercices.models.CaseDesign;
import edu.globant.day1.oop.exercices.models.CaseDevice;

public interface InventoryObserver {
	public void doUpdate(Case aCase);
}
