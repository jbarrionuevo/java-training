package securing.exercises.services;

public class Sale {

	private SaleEmployee employee;
	private String saleId;

	public Sale(String id, SaleEmployee employee) {
		this.saleId = id;
		this.employee = employee;
	}

	public String getSaleId() {
		return this.saleId;
	}

	public SaleEmployee getEmployee() {
		return this.employee;
	}

	@Override
	public String toString() {
		return "saleId: " + this.saleId + " employeeName: " + this.getEmployee().getName();
	}

}
