package ilan.models;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public abstract class CaseSeller extends Employee {
	
	//whenever a caseSeller receives an order, its a new sale with the DRAFT status; if then, the sale is not
	//succesfull, its marked as CANCELLED; otherwise, its marked as PAID, and it could then be REFUND
	
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "seller", cascade = CascadeType.ALL)
	private Collection<Sale> sales;
	
	public CaseSeller(){}
	
	public CaseSeller(String name){
		super(name);
		this.sales=new ArrayList<Sale>();
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
