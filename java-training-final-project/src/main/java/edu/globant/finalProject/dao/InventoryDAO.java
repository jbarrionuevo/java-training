package edu.globant.finalProject.dao;

import java.util.ArrayList;

import edu.globant.finalProject.model.Case.Case;
import edu.globant.finalProject.model.Inventory.CaseStock;

public class InventoryDAO {

	public void add(Case c) {
		System.out.println("adding case: "+c.getName());
	}

	public ArrayList<CaseStock> getAll() {
		System.out.println("obteniendo todo el stock de todos los productos de la bd");
		return new ArrayList<CaseStock>();
	}

}
