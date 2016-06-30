package ilan.services;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ilan.daos.CaseSellerDao;
import ilan.exceptions.CaseSellerNotFoundException;
import ilan.models.CaseSeller;
import ilan.models.Sale;


@Service
public class CaseSellerService {
	
	private final static Logger log = LoggerFactory.getLogger(CaseSellerService.class);
	
	@Autowired
	CaseSellerDao caseSellerDao;
	
	
	public CaseSellerDao getCaseSellerDao() {
		return caseSellerDao;
	}

	public void setCaseSellerDao(CaseSellerDao caseSellerDao) {
		this.caseSellerDao = caseSellerDao;
	}
	
	public void save(CaseSeller caseSeller){
		caseSellerDao.save(caseSeller);
	}

	public void addSale(Long caseSellerId, Sale sale) {
		CaseSeller looked = caseSellerDao.findOne(caseSellerId);
		if(looked==null) throw new CaseSellerNotFoundException(caseSellerId);
		sale.setSeller(looked);
		looked.addSale(sale);
		caseSellerDao.save(looked);
	}
	
}
