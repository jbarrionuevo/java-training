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

import ilan.daos.CaseOrderDao;
import ilan.daos.OrderAlertDao;
import ilan.daos.ProviderDao;
import ilan.exceptions.OrderAlertNotFoundException;
import ilan.exceptions.OrderAlreadyMadeException;
import ilan.models.CaseOrder;
import ilan.models.CaseProduct;
import ilan.models.OrderAlert;
import ilan.models.Provider;

@Service
public class ProviderService {
	
	private final static Logger log = LoggerFactory.getLogger(ProviderService.class);
	
	@Autowired
	private ProviderDao providerDao;
	@Autowired
	private OrderAlertDao orderAlertDao;
	@Autowired
	private CaseOrderDao caseOrderDao;
	
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
	public Page<Provider> findAllProviders(Integer page, Integer size){
		return providerDao.findAll(new PageRequest(page, size));
	}
	
	@Transactional
	public void addOrder(Long providerId, CaseOrder caseOrder, Long orderAlertId) {
		Provider provider = providerDao.findOne(providerId);
		if(provider==null) throw new ProviderNotFoundException(providerId.toString());
		caseOrder.setThirdPartyParticipant(provider);
		provider.addOrder(caseOrder);
		providerDao.save(provider);
		if(orderAlertId!=0){
			OrderAlert orderAlert = orderAlertDao.findOne(orderAlertId);
			if(orderAlert==null) throw new OrderAlertNotFoundException(orderAlertId);
			if(orderAlert.isMade()) throw new OrderAlreadyMadeException(orderAlertId);
			orderAlert.setMade(true);
			orderAlertDao.save(orderAlert);
		}
	}

	public Collection<CaseOrder> getProviderOrders(Long providerId,String delivered) {
		Provider provider = providerDao.findOne(providerId);
		if(provider==null) throw new ProviderNotFoundException(providerId.toString());
		if(delivered.equals("all")) return caseOrderDao.findByThirdPartyParticipant(provider);
		else{
			if(delivered.equals("false")) return caseOrderDao.findByThirdPartyParticipantAndDateOfDeliveryIsNull(provider);
			else return caseOrderDao.findByThirdPartyParticipantAndDateOfDeliveryIsNotNull(provider);
		}
	}

	
}
