package ilan.models;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;

import org.thymeleaf.util.Validate;

import ilan.interfaces.StoreSellerInterface;

@Entity
public class StoreSeller extends CaseSeller implements StoreSellerInterface{

	private String store;
	
	public StoreSeller(){}
	
	public StoreSeller(String name){
		super(name);
	}
	
	public StoreSeller(String name,Collection<Sale> sales, String store){
		super(name,sales);
		Validate.notEmpty(store,"Store cannot be empty");
		this.store=store;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}
}
