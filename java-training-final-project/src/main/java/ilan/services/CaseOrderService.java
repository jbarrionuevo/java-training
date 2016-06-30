package ilan.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ilan.daos.CaseOrderDao;
import ilan.models.CaseOrder;
import ilan.models.CaseProduct;
import ilan.models.Provider;

@Service
public class CaseOrderService{
	
	private final static Logger log = LoggerFactory.getLogger(CaseOrderService.class);
	
	@Autowired
	private CaseOrderDao orderDao;
	
	@Transactional
	public void saveOrders(CaseOrder... orders){
		 for (CaseOrder order: orders) {
	            log.info("Persisting Order [" + order + "] to database...");
	            orderDao.save(order);
	     }
	}
	
	public CaseOrder save(CaseOrder order){
		return orderDao.save(order);
	}
	
	public Collection<CaseOrder> findAllOrders() {
	        return orderDao.findAll();
	}
	
	
	
}
