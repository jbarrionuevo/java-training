package ilan.services;
import java.util.Map;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ilan.daos.CaseOrderDao;
import ilan.daos.CaseSellerDao;
import ilan.daos.CaseWrapperDao;
import ilan.daos.CustomerDao;
import ilan.enums.SaleStatus;
import ilan.exceptions.CaseSellerNotFoundException;
import ilan.exceptions.CaseWrapperNotFoundException;
import ilan.exceptions.CustomerNotFoundException;
import ilan.exceptions.NotEnoughStockException;
import ilan.models.CaseSeller;
import ilan.models.CaseWrapper;
import ilan.models.Customer;
import ilan.models.Sale;


@Service
public class CaseSellerService {
	
	private final static Logger log = LoggerFactory.getLogger(CaseSellerService.class);
	
	@Autowired
	CaseSellerDao caseSellerDao;
	@Autowired
	CustomerDao customerDao;
	@Autowired
	CaseWrapperDao caseWrapperDao;
	@Autowired
	CaseOrderDao caseOrderDao;
	
	public CaseSellerDao getCaseSellerDao() {
		return caseSellerDao;
	}

	public void setCaseSellerDao(CaseSellerDao caseSellerDao) {
		this.caseSellerDao = caseSellerDao;
	}
	
	public void save(CaseSeller caseSeller){
		caseSellerDao.save(caseSeller);
	}

	@Transactional
	public void addSale(Long caseSellerId, Sale sale) {
		CaseSeller looked = caseSellerDao.findOne(caseSellerId);
		if(looked==null) throw new CaseSellerNotFoundException(caseSellerId);
//		if(sale.getReceipts().iterator().next().getCustomer().getId()!=null){
//			Customer lookedCustomer = customerDao.findOne(sale.getReceipts().iterator().next().getCustomer().getId());
//			if(lookedCustomer==null) throw new CustomerNotFoundException(sale.getReceipts().iterator().next().getCustomer().getId());
//		}else{
//			customerDao.save(sale.getReceipts().iterator().next().getCustomer());
//		}
		for (Map.Entry<Long, Integer> entry : sale.getOrder().getRequestCases().entrySet()){
			CaseWrapper wrapper = caseWrapperDao.findOne(entry.getKey());
			if(wrapper==null) throw new CaseWrapperNotFoundException(entry.getKey());
//			if(wrapper.getCurrentStock()<entry.getValue()) throw new NotEnoughStockException(wrapper.getMyCase().toString());
	    }
		caseOrderDao.save(sale.getOrder());
//		sale.getReceipts().iterator().next().setSale(sale);
		sale.setSeller(looked);
		sale.setStatus(SaleStatus.DRAFT);
		looked.addSale(sale);
		caseSellerDao.save(looked);
	}
	
}
