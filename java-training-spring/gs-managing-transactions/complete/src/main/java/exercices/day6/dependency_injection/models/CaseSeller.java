package exercices.day6.dependency_injection.models;

import java.util.Collection;

public abstract class CaseSeller extends Employee {
	
	//whenever a caseSeller receives an order, its a new sale with the DRAFT status; if then, the sale is not
	//succesfull, its marked as CANCELLED; otherwise, its marked as PAID, and it could then be REFUND
	private Collection<Sale> sales;
	
	public CaseSeller(){}
	
	public CaseSeller(String name){
		super(name);
	}
	
	public CaseSeller(String name, Collection<Sale> sales) {
		super(name);
		this.sales = sales;
	}

	public void addSale(Sale sale){
		this.sales.add(sale);
	}
	
	public Collection<Sale> getSales() {
		return sales;
	}

	public void setSales(Collection<Sale> sales) {
		this.sales = sales;
	}

	
	
}
