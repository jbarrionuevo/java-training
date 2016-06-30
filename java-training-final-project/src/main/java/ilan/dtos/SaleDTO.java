package ilan.dtos;

import ilan.enums.SaleStatus;

public class SaleDTO {
	private Long id;
	private ReceiptDTO receipt;
	private CaseOrderDTO caseOrder;
	private CaseSellerDTO caseSeller;
	private SaleStatus status;
	
	public SaleDTO(CaseOrderDTO caseOrder, CaseSellerDTO caseSeller, ReceiptDTO receipt) {
		super();
		this.setReceipt(receipt);
		this.setCaseOrder(caseOrder);
		this.setCaseSeller(caseSeller);
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

	public ReceiptDTO getReceipt() {
		return receipt;
	}

	public void setReceipt(ReceiptDTO receipt) {
		this.receipt = receipt;
	}

	public CaseOrderDTO getCaseOrder() {
		return caseOrder;
	}

	public void setCaseOrder(CaseOrderDTO caseOrder) {
		this.caseOrder = caseOrder;
	}

	public CaseSellerDTO getCaseSeller() {
		return caseSeller;
	}

	public void setCaseSeller(CaseSellerDTO caseSeller) {
		this.caseSeller = caseSeller;
	}
}
