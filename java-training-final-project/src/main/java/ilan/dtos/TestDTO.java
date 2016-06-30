package ilan.dtos;

public class TestDTO {
	private Long id;
	private ReceiptDTO receipt;
	private CaseOrderDTO caseOrder;
	
	public TestDTO(){}
	
	public TestDTO(CaseOrderDTO caseOrder, ReceiptDTO receipt){
		this.receipt=receipt;
		this.caseOrder=caseOrder;
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
}
