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

import org.thymeleaf.util.Validate;

@Entity
public abstract class CaseSeller extends Employee {
	
	//whenever a caseSeller receives an order, its a new sale with the DRAFT status; if then, the sale is not
	//succesfull, its marked as CANCELLED; otherwise, its marked as PAID, and it could then be REFUND
	
	private String store;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "seller", cascade = CascadeType.ALL)
	private Collection<Sale> sales;
	
	public CaseSeller(){}
	
	public CaseSeller(String name,String store){
		super(name);
		Validate.notNull(name, "Name cannot be null");
		Validate.notNull(store, "Store cannot be null");
		this.sales=new ArrayList<Sale>();
		this.setStore(store);
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

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}
}
