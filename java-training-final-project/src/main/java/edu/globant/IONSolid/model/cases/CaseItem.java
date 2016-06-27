package edu.globant.IONSolid.model.cases;

public class CaseItem {

	//unique id for every item
	private String caseItemId;
	private Double price;
	public Case itemDetail;
	
	public CaseItem(String itemId, Double price, Case itemDetail) {
		this.caseItemId = itemId;
		this.price = price;
		this.itemDetail = itemDetail;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCaseItemId() {
		return caseItemId;
	}

	public Case getItemDetail() {
		return itemDetail;
	}
}
