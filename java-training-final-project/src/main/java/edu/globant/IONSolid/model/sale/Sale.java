package edu.globant.IONSolid.model.sale;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.globant.IONSolid.model.cases.CaseItem;
import edu.globant.IONSolid.model.employee.SaleEmployee;

public class Sale {

	private String idSale;
	private SaleEmployee seller;
	private SaleState saleState;
	private Date saleCreationDate;
	private List<CaseItem> saleItems = null;

	public Sale(String idSale, SaleEmployee saleEmployee) {
		this.idSale = idSale;
		this.seller = saleEmployee;
		this.saleState = SaleState.DRAFT;
		this.saleCreationDate = new Date();
		saleItems = new ArrayList<CaseItem>();
	}

	public Sale(String idSale, SaleEmployee saleEmployee, List<CaseItem> saleItems) {
		this.idSale = idSale;
		this.seller = saleEmployee;
		this.saleState = SaleState.DRAFT;
		this.saleCreationDate = new Date();
		this.saleItems = saleItems;
	}

	public String getIdSale() {
		return idSale;
	}

	public SaleEmployee getSeller() {
		return seller;
	}

	public SaleState getSaleState() {
		return saleState;
	}
	
	public void setNewSaleState(SaleState newState) {
		this.saleState = newState;
	}

	public Date getSaleCreationDate() {
		return saleCreationDate;
	}

	public Double getSellAmount() {
		return saleItems.stream().mapToDouble(i -> i.getPrice()).sum();
	}

	public void addSaleItems(CaseItem newItem) {
		saleItems.add(newItem);
	}

	public void removeSaleItems(CaseItem saleItem) {
		saleItems.removeIf(i -> i.getCaseItemId().equals(saleItem.getCaseItemId()));
	}
}
