package ilan.services;
import java.util.Collection;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ilan.daos.ProviderDao;
import ilan.models.Provider;

@Service
public class ProviderService {
	
	private final static Logger log = LoggerFactory.getLogger(ProviderService.class);
	
	@Autowired
	private ProviderDao providerDao;

	public void saveProvider(Provider newProvider){
		providerDao.save(newProvider);
	}
	
	@Transactional
	public void saveProviders(Provider... providers){
		 for (Provider provider: providers) {
	            log.info("Persisting Provider [" + provider + "] to database...");
	            providerDao.save(provider);
	     }
	}
	
	public Collection<Provider> findAllProviders(){
		return providerDao.findAll();
	}
	
}
