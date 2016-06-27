package ilan.services;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ilan.daos.CaseSellerDao;


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
	
}
