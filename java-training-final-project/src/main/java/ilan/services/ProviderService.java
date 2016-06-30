package ilan.services;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.ProviderNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ilan.daos.ProviderDao;
import ilan.models.CaseOrder;
import ilan.models.CaseProduct;
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
	
	public void generateOrder(Long providerId, HashMap<Long,Integer> requestCases){
		Provider provider = providerDao.findOne(providerId);
		if(provider==null) throw new ProviderNotFoundException(providerId.toString());
		provider.addOrder(new CaseOrder(requestCases, new Date()));
		providerDao.save(provider);
	}
	
}
