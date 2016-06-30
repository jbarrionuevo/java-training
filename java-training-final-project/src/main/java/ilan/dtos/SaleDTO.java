package ilan.dtos;

import ilan.enums.SaleStatus;
import ilan.models.CaseOrder;
import ilan.models.CaseSeller;
import ilan.models.Receipt;

public class SaleDTO {
	private Long id;
	private Receipt receipt;
	private CaseOrder caseOrder;
	private CaseSeller caseSeller;
	private SaleStatus status;
	
	public SaleDTO(CaseOrder caseOrder, CaseSeller caseSeller, Receipt receipt) {
		super();
		this.receipt=receipt;
		this.caseOrder=caseOrder;
		this.setCaseSeller(caseSeller);
		this.status = SaleStatus.DRAFT;
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
		return caseOrder;
	}

	public void setOrder(CaseOrder order) {
		this.caseOrder = order;
	}

	public CaseSeller getCaseSeller() {
		return caseSeller;
	}

	public void setCaseSeller(CaseSeller caseSeller) {
		this.caseSeller = caseSeller;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
