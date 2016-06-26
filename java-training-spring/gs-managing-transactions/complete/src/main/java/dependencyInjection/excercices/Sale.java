package dependencyInjection.excercices;

public class Sale {

	private SaleEmployee employee;
	private SaleState saleState;
	private String saleId;

	public Sale(String id, SaleEmployee employee) {
		this.saleId = id;
		this.employee = employee;
		this.saleState = SaleState.DRAFT;
	}

	public String getSaleId() {
		return this.saleId;
	}

	public SaleEmployee getEmployee() {
		return this.employee;
	}

	public SaleState getState() {
		return this.saleState;
	}

	@Override
	public String toString() {
		return "saleId: " + this.saleId + " saleState: " + this.saleState.toString() + " employeeName: "
				+ this.getEmployee().getName();
	}

}
