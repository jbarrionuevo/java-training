package model;

import java.util.Date;
import java.util.List;

public abstract class Sell {

	private List<Case> items;

	private Seller seller;

	private Date sellDate;
	// status possible values: draft, paid, cancelled or refund
	private SellStatus status;
	// description of the status
	private String description;

	private Store store;

	public List<Case> getItems() {
		return items;
	}

	public void setItems(List<Case> items) {
		this.items = items;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public Date getSellDate() {
		return sellDate;
	}

	public void setSellDate(Date sellDate) {
		this.sellDate = sellDate;
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

}
