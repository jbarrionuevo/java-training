package dia1.models;

import java.util.Date;

import dia1.enums.Gender;
import dia1.interfaces.DeliverySellerInterface;
import dia1.interfaces.StoreSellerInterface;


public class CompleteSeller extends CaseSeller implements DeliverySellerInterface,StoreSellerInterface{

	public CompleteSeller(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
}
