package edu.globant.finalProject.model.Inventory;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;

import edu.globant.finalProject.model.Case.Case;

public class Inventory{

	@Autowired
	private ArrayList<CaseStock> casesStock;

	public ArrayList<CaseStock> getCasesStock() {
		return casesStock;
	}

	public void setCasesStock(ArrayList<CaseStock> casesStock) {
		this.casesStock = casesStock;
	}
	
}
