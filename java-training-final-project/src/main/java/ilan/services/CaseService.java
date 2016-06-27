package ilan.services;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ilan.daos.CaseDao;
import ilan.models.CaseProduct;
import ilan.models.CaseDesign;


@Service
public class CaseService{
	
	private final static Logger log = LoggerFactory.getLogger(CaseService.class);
	
//	@Autowired //commented to show that the injection is being taken from the beans.xml file
	CaseDao caseDao;
	
	public void saveCase(CaseProduct newCase){
	    caseDao.save(newCase);
	}
	
	@Transactional
	public void saveCases(CaseProduct... cases){
		 for (CaseProduct aCase: cases) {
	            log.info("Persisting Case [" + aCase + "] to database...");
	            caseDao.save(aCase);
	     }
	}
	
	public Collection<CaseProduct> findAllCases() {
        return caseDao.findAll();
	}
	
	public Collection<CaseProduct> findCasesWithDesign(CaseDesign design) {
        return caseDao.findByDesign(design);
	}

	public CaseDao getCaseDao() {
		return caseDao;
	}

	public void setCaseDao(CaseDao caseDao) {
		this.caseDao = caseDao;
	}
	
	
}
