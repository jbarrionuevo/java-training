package dia1.models;

import java.util.Collection;

public class CaseSeller extends Employee {
	
	private Collection<Sale> sales;
	
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
