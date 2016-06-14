package dia1.models;

import java.util.Collection;
import java.util.Date;

import dia1.enums.Gender;
import dia1.interfaces.StoreSellerInterface;


public class StoreSeller extends CaseSeller implements StoreSellerInterface{

	private String store;
	
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
