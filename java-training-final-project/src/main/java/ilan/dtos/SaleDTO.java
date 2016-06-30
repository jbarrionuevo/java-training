package ilan.dtos;

import java.util.Collection;

import ilan.enums.SaleStatus;

public class SaleDTO {
	private Long id;
	private Collection<ReceiptDTO> receipts;
	private CaseOrderDTO caseOrder;
	private SaleStatus status;
	
	public SaleDTO(){}
	
	public SaleDTO(CaseOrderDTO caseOrder, Collection<ReceiptDTO> receipts) {
		this.receipts=receipts;
		this.caseOrder=caseOrder;
		this.status = SaleStatus.DRAFT;
	}

	public SaleStatus getStatus() {
		return status;
	}

	public void setStatus(SaleStatus status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public CaseOrderDTO getCaseOrder() {
		return caseOrder;
	}

	public void setCaseOrder(CaseOrderDTO caseOrder) {
		this.caseOrder = caseOrder;
	}

	public Collection<ReceiptDTO> getReceipts() {
		return receipts;
	}

	public void setReceipts(Collection<ReceiptDTO> receipts) {
		this.receipts = receipts;
	}
}
