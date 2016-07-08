package ilan.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Inventory {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "inventory", cascade = CascadeType.ALL)
	private Collection<CaseWrapper> stock;

	public Inventory() {
		this.stock = new ArrayList<CaseWrapper>();
	}
	
	public void addCase(CaseProduct aCase, int quantity, int minimumStock){
		CaseWrapper wrapper = new CaseWrapper(aCase, minimumStock, quantity, this);
		this.stock.add(wrapper);
	}
	
	public Collection<CaseWrapper> getStock() {
		return stock;
	}
	
	public void setStock(Collection<CaseWrapper> stock) {
		this.stock = stock;
	}


	
	
	
}
