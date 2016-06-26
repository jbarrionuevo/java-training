package exercices.dependencyInjection;

public class Sale {

	private SaleEmployee employee;
	private SaleState saleState;
	private String saleId;
	
	public Sale(String id, SaleEmployee employee) {
		this.saleId = id;
		this.employee = employee;
		this.saleState = SaleState.DRAFT;
	}
	
	public String getString() {
		return this.saleId;
	}
	
	public SaleEmployee getEmployee() {
		return this.employee;
	}
	
	public SaleState getState() {
		return this.saleState;
	}
	
}
