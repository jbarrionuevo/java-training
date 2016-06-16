package edu.globant.day1.designpatterns.IONSolid.model.receipt;

public class Receipt {

	private Long receiptId;
	private ReceiptState state;
	private float amount;
	
	public Receipt(Long receiptId, float amount) {
		
	}
	
	public void setSalteState(ReceiptState newState) {
		this.state = newState;
	}

	public ReceiptState getState() {
		return state;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Long getReceiptId() {
		return receiptId;
	}

	public void setReceiptId(Long receiptId) {
		this.receiptId = receiptId;
	}

	public void setState(ReceiptState state) {
		this.state = state;
	}
}
