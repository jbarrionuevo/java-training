package exercices.day6.dependency_injection.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public abstract class CaseSeller extends Employee {
	
	//whenever a caseSeller receives an order, its a new sale with the DRAFT status; if then, the sale is not
	//succesfull, its marked as CANCELLED; otherwise, its marked as PAID, and it could then be REFUND
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToMany
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	
}
