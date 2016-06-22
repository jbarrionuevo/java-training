package exercices.day6.dependency_injection;

import java.util.Collection;
import java.util.Date;

import exercices.day6.dependency_injection.interfaces.StoreSellerInterface;


public class StoreSeller extends CaseSeller implements StoreSellerInterface{

	private String store;
	
	public StoreSeller(){}
	
	public StoreSeller(String name){
		super(name);
	}
	
	public StoreSeller(String name,Collection<Sale> sales, String store){
		super(name,sales);
		this.store=store;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}
}
