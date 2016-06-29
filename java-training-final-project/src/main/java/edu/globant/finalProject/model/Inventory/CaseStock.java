package edu.globant.finalProject.model.Inventory;

import org.springframework.beans.factory.annotation.Autowired;

import edu.globant.finalProject.model.Case.Case;

public class CaseStock {
	
	@Autowired
	private Case kase;
	
	@Autowired
	private int actualStock;
	
	@Autowired
	private int minimumQuantity;

	public Case getKase() {
		return kase;
	}

	public void setKase(Case kase) {
		this.kase = kase;
	}

	public int getActualStock() {
		return actualStock;
	}

	public void setActualStock(int actualStock) {
		this.actualStock = actualStock;
	}

	public int getMinimumQuantity() {
		return minimumQuantity;
	}

	public void setMinimumQuantity(int minimumQuantity) {
		this.minimumQuantity = minimumQuantity;
	}
	
}
