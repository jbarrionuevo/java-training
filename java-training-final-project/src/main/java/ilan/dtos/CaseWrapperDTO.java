package ilan.dtos;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ilan.models.CaseProduct;
import ilan.models.Inventory;

public class CaseWrapperDTO {
	private CaseProductDTO myCase;	
	private Long id;
	private int minimumStock;
	private int currentStock;
	
	public CaseWrapperDTO(){}
	
	public CaseWrapperDTO(CaseProductDTO myCase, int minimumStock, int currentStock) {
		super();
		this.myCase = myCase;
		this.minimumStock = minimumStock;
		this.currentStock = currentStock;
	}
	
	public CaseProductDTO getMyCase() {
		return myCase;
	}
	public void setMyCase(CaseProductDTO myCase) {
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
