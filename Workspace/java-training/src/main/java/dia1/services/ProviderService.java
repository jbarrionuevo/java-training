package dia1.services;

import java.util.Date;

import dia1.daos.ProviderDao;
import dia1.models.Case;
import dia1.models.Order;
import dia1.models.Provider;
import dia1.models.ProviderOrder;

public class ProviderService {
	private ProviderDao providerDao;
	
	public void addOrderToProvider(Order order, Provider provider){
		provider.addOrder(order);
		System.out.println("Add order");
		//update provider in db
	}

	public ProviderDao getProviderDao() {
		return providerDao;
	}

	public void setProviderDao(ProviderDao providerDao) {
		this.providerDao = providerDao;
	}
}
