package edu.globant.day1.ddd.exercices.models;

import edu.globant.day1.oop.exercices.enums.SaleStatus;

public class Sale {
	private Receipt receipt;
	private CaseOrder order;
	private SaleStatus status;
	private CaseSeller seller;
	
	public Sale(CaseOrder order, Receipt receipt, CaseSeller seller) {
		super();
		this.order=order;
		this.status = SaleStatus.DRAFT;
		this.receipt=receipt;
		this.seller=seller;
	}
	
	public Receipt getReceipt() {
		return receipt;
	}
	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	public SaleStatus getStatus() {
		return status;
	}

	public void setStatus(SaleStatus status) {
		this.status = status;
	}

	public CaseOrder getOrder() {
		return order;
	}

	public void setOrder(CaseOrder order) {
		this.order = order;
	}

	public CaseSeller getSeller() {
		return seller;
	}

	public void setSeller(CaseSeller seller) {
		this.seller = seller;
	}

	
	
	
	
}
