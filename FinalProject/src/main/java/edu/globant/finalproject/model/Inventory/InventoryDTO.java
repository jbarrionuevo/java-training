package edu.globant.finalproject.model.Inventory;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

public class InventoryDTO{

	@Autowired
	private ArrayList<CaseStockDTO> casesStock;

	public ArrayList<CaseStockDTO> getCasesStock() {
		return casesStock;
	}

	public void setCasesStock(ArrayList<CaseStockDTO> casesStock) {
		this.casesStock = casesStock;
	}
	
}
