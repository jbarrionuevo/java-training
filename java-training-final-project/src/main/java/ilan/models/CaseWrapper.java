package ilan.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.thymeleaf.util.Validate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CaseWrapper {
	
	@ManyToOne
	private CaseProduct myCase;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JsonIgnore
	private Inventory inventory;
	
	private int minimumStock;
	private int currentStock;
	
	public CaseWrapper(){}
	
	public CaseWrapper(CaseProduct myCase, Integer minimumStock, Integer currentStock, Inventory inventory) {
		super();
		Validate.notNull(myCase, "myCase cannot be null");
		Validate.notNull(minimumStock, "minimumStock cannot be null");
		Validate.notNull(currentStock, "currentStock cannot be null");
		Validate.notNull(inventory, "inventory cannot be null");
		this.myCase = myCase;
		this.minimumStock = minimumStock;
		this.currentStock = currentStock;
		this.inventory=inventory;
	}
	
	public CaseProduct getMyCase() {
		return myCase;
	}
	public void setMyCase(CaseProduct myCase) {
		this.myCase = myCase;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
