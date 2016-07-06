package edu.globant.finalproject.Service;

import java.util.ArrayList;
import java.util.List;

import edu.globant.finalproject.hibernate.Case;
import edu.globant.finalproject.hibernate.CaseStock;
import edu.globant.finalproject.model.Case.CaseDTO;
import edu.globant.finalproject.model.Inventory.CaseStockDTO;

public interface InventoryService {
	void add(Case c);
	List<CaseStock> getAll();
}
