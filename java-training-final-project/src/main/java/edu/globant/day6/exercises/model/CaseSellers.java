package edu.globant.day6.exercises.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import edu.globant.day6.exercises.enums.SellerType;

@Entity
public class CaseSellers extends Employee {

	@Id
	@GeneratedValue
	private Long id;
	private SellerType type;
	@OneToMany
	private Collection<Sale> sales;

	public Collection<Sale> getSales() {
		return sales;
	}

	public void setSales(Collection<Sale> sales) {
		this.sales = sales;
	}
	
	public void addNewSale (Sale sale) {
		this.sales.add(sale);
	}

	public SellerType getType() {
		return type;
	}

	public void setType(SellerType type) {
		this.type = type;
	}
}
