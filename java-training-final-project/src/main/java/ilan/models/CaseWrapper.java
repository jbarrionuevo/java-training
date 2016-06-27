package ilan.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CaseWrapper {
	@ManyToOne
	private CaseProduct aCase;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	private Inventory inventory;
	
	private int minimumStock;
	private int currentStock;
	
	public CaseWrapper(CaseProduct aCase, int minimumStock, int currentStock, Inventory inventory) {
		super();
		this.aCase = aCase;
		this.minimumStock = minimumStock;
		this.currentStock = currentStock;
		this.inventory=inventory;
	}
	
	public CaseProduct getaCase() {
		return aCase;
	}
	public void setaCase(CaseProduct aCase) {
		this.aCase = aCase;
	}
	public int getMinimumStock() {
		return minimumStock;
	}
	public void setMinimumStock(int minimumStock) {
		this.minimumStock = minimumStock;
	}
	public int getCurrentStock() {
		return currentStock;
	}
	public void setCurrentStock(int currentStock) {
		this.currentStock = currentStock;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
	
}
