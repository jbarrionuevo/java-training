package edu.globant.day1.multi_tier_applications.exercices.structure.services;

import java.util.Date;

import edu.globant.day1.oop.exercices.daos.ProviderDao;
import edu.globant.day1.oop.exercices.models.Order;
import edu.globant.day1.oop.exercices.models.Provider;

public class ProviderService {
	private ProviderDao providerDao;

	public ProviderDao getProviderDao() {
		return providerDao;
	}

	public void setProviderDao(ProviderDao providerDao) {
		this.providerDao = providerDao;
	}
}
