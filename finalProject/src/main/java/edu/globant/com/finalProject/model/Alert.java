package edu.globant.com.finalProject.model;

public class Alert {

	private int id;
	private CaseStock caseStock;
	private CaseProvider caseProvider;
	
	public Alert(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CaseStock getCaseStock() {
		return caseStock;
	}

	public void setCaseStock(CaseStock caseStock) {
		this.caseStock = caseStock;
	}

	public CaseProvider getCaseProvider() {
		return caseProvider;
	}

	public void setCaseProvider(CaseProvider caseProvider) {
		this.caseProvider = caseProvider;
	}

	@Override
	public String toString() {
		return "Alert [id=" + id + ", caseStock=" + caseStock + ", caseProvider=" + caseProvider + "]";
	}
	
	
}
