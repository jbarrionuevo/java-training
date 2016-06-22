package exercices.day6.dependency_injection.services;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exercices.day6.dependency_injection.daos.ProviderDao;

@Service
public class ProviderService {
	
	@Autowired
	private ProviderDao providerDao;

	public ProviderDao getProviderDao() {
		return providerDao;
	}

	public void setProviderDao(ProviderDao providerDao) {
		this.providerDao = providerDao;
	}
}
