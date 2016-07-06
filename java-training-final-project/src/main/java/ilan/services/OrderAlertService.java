package ilan.services;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ilan.daos.OrderAlertDao;
import ilan.models.OrderAlert;

@Service
public class OrderAlertService {
	private final static Logger log = LoggerFactory.getLogger(OrderAlertService.class);
	
	@Autowired
	OrderAlertDao orderAlertDao;
	
	public Collection<OrderAlert> findAll(){
		return orderAlertDao.findAll();
	}

	public Collection<OrderAlert> findNotMadeAlerts() {
		return orderAlertDao.findByMade(false);
	}

}
