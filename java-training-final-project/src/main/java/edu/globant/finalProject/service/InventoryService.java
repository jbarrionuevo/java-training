package edu.globant.finalProject.service;

import java.util.ArrayList;

import edu.globant.finalProject.model.Case.Case;
import edu.globant.finalProject.model.Inventory.CaseStock;

public interface InventoryService {
	void add(Case c);
	ArrayList<CaseStock> getAll();
}
