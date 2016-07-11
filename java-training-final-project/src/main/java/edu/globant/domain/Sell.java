package edu.globant.domain;

import java.util.List;

import org.apache.commons.lang3.Validate;

public class Sell extends BaseEntity{

	private List<Case> items;

	private List<SellStatus> sellStatus;

	private Employee seller;

	// status possible values: draft, paid, cancelled or refund
	private SellStatus status;

	private String description;

	private Store store;

	public Sell(Store store, Employee seller) {		
		Validate.notNull(store, "The store cannot be null.");
		Validate.notNull(seller, "The seller cannot be null.");

		this.seller = seller;
		this.store = store;
	}

	public List<Case> getItems() {
		return items;
	}

	public void setItems(List<Case> items) {
		this.items = items;
	}

	public Employee getSeller() {
		return seller;
	}

	public void setSeller(Employee seller) {
		this.seller = seller;
	}

	public SellStatus getStatus() {
		return status;
	}

	public void setStatus(SellStatus status) {
		this.status = status;
	}

	public String getStatusDescription() {
		return description;
	}

	public void setStatusDescription(String statusDescription) {
		this.description = statusDescription;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public List<SellStatus> getSellStatusHistory() {
		return sellStatus;
	}

	public void setSellStatusHistory(List<SellStatus> sellStatusHistory) {
		this.sellStatus = sellStatusHistory;
	}

}
