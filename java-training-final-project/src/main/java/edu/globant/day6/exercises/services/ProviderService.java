package edu.globant.day6.exercises.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.globant.day6.exercises.DAO.ProviderServiceDAO;

@Service
public class ProviderService {
	
	@Autowired
	ProviderServiceDAO providerServiceDao;

	public ProviderServiceDAO getProviderServiceDao() {
		return providerServiceDao;
	}

	public void setProviderServiceDao(ProviderServiceDAO providerServiceDao) {
		this.providerServiceDao = providerServiceDao;
	}

}
