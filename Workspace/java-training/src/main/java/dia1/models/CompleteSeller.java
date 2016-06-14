package dia1.models;

import java.util.Date;

import dia1.enums.Gender;
import dia1.interfaces.DeliverySellerInterface;
import dia1.interfaces.StoreSellerInterface;


public class CompleteSeller extends CaseSeller implements DeliverySellerInterface,StoreSellerInterface{

	public static void main(String[] args){
		CompleteSeller test = new CompleteSeller();
		test.deliver(); //testing Delivery Seller method
		
		CaseDesign designMock = new CaseDesign("IPhone design");
		CaseDevice deviceMock = new CaseDevice("IPhone 6");
		Case caseMock = new Case(designMock, deviceMock, 100.50);
		Customer customerMock = new Customer("ilan", "LP 7 y 50", 22, Gender.M);
		StoreOrder orderMock = new StoreOrder(caseMock, 10, new Date(),customerMock);
		Sale saleMock = new Sale(orderMock);
		test.sellCase(saleMock,test); //testing Store Seller method
	}
}
