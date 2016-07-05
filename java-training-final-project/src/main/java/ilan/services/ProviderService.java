package ilan.services;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
	
	public Page<Provider> findAllProviders(Integer page, Integer size){
		return providerDao.findAll(new PageRequest(page, size));
	}
	

	public void addOrder(Long providerId, CaseOrder caseOrder) {
		Provider provider = providerDao.findOne(providerId);
		if(provider==null) throw new ProviderNotFoundException(providerId.toString());
		provider.addOrder(caseOrder);
		providerDao.save(provider);
	}
	
}
