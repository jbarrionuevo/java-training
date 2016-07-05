package edu.globant.finalproject.model.Inventory;

import edu.globant.finalproject.model.Case.CaseDTO;

public class CaseStockDTO{
	
	private CaseDTO kase;
	private int actualStock;
	private int minimumQuantity;

	public CaseDTO getKase() {
		return kase;
	}

	public void setKase(CaseDTO kase) {
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
