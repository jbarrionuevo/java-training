package dia1.models;

import java.util.Collection;
import java.util.Date;

import dia1.enums.Gender;
import dia1.interfaces.StoreSellerInterface;


public class StoreSeller extends CaseSeller implements StoreSellerInterface{

	private String store;
	
	public StoreSeller(){}
	
	public StoreSeller(Collection<Sale> sales, Logistic logistic, String store){
		super(sales,logistic);
		this.store=store;
	}
	
	public static void main(String[] args){
		StoreSeller test = new StoreSeller();
		test.registerOrder(new StoreOrder());
		CaseDesign designMock = new CaseDesign("IPhone design");
		CaseDevice deviceMock = new CaseDevice("IPhone 6");
		Case caseMock = new Case(designMock, deviceMock, 100.50);
		Customer customerMock = new Customer("ilan", "LP 7 y 50", 22, Gender.M);
		StoreOrder orderMock = new StoreOrder(caseMock, 10, new Date(),customerMock);
		Sale saleMock = new Sale(orderMock);
		test.sellCase(saleMock,test);
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}
}
