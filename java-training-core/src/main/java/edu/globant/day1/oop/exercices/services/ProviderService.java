package edu.globant.day1.oop.exercices.services;

import java.util.Date;

import edu.globant.day1.oop.exercices.daos.ProviderDao;
import edu.globant.day1.oop.exercices.models.Order;
import edu.globant.day1.oop.exercices.models.Provider;

public class ProviderService {
	private ProviderDao providerDao;
	
	public void addOrderToProvider(Order order, Provider provider){
		provider.addOrder(order);
		System.out.println("Add order to Provider "+provider.getName());
		//update provider in db
	}

	public ProviderDao getProviderDao() {
		return providerDao;
	}

	public void setProviderDao(ProviderDao providerDao) {
		this.providerDao = providerDao;
	}
}
