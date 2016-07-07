package ilan.models;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;

import org.thymeleaf.util.Validate;

import ilan.interfaces.StoreSellerInterface;

@Entity
public class StoreSeller extends CaseSeller implements StoreSellerInterface{

	
	
	public StoreSeller(){}
	
	public StoreSeller(String name, String store){
		super(name,store);
	}

}
