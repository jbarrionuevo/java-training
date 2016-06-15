package edu.globant.day1.multi_tier_applications.exercices.layers.dtos;

import javax.validation.Valid;

import edu.globant.day1.oop.exercices.enums.SaleStatus;

public class SaleDTO {
	@Valid
	private ReceiptDTO receipt;
	@Valid
	private OrderDTO order;
	private SaleStatus status;
	
	public SaleDTO(OrderDTO order) {
		super();
		this.order=order;
		this.status = SaleStatus.DRAFT;
	}
	
	public ReceiptDTO getReceipt() {
		return receipt;
	}
	public void setReceipt(ReceiptDTO receipt) {
		this.receipt = receipt;
	}

	public SaleStatus getStatus() {
		return status;
	}

	public void setStatus(SaleStatus status) {
		this.status = status;
	}

	public OrderDTO getOrder() {
		return order;
	}

	public void setOrder(OrderDTO order) {
		this.order = order;
	}

	
	
	
	
}
