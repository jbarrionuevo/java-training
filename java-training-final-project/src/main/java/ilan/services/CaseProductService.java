package ilan.services;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ilan.daos.CaseProductDao;
import ilan.models.CaseProduct;
import ilan.models.CaseDesign;


@Service
public class CaseProductService{
	
	private final static Logger log = LoggerFactory.getLogger(CaseProductService.class);
	
//	@Autowired //commented to show that the injection is being taken from the beans.xml file
	CaseProductDao caseProductDao;
	
	public CaseProduct saveCase(CaseProduct newCase){
	    return caseProductDao.save(newCase);
	}
	
	@Transactional
	public void saveCases(CaseProduct... cases){
		 for (CaseProduct aCase: cases) {
	            log.info("Persisting Case [" + aCase + "] to database...");
	            caseProductDao.save(aCase);
	     }
	}
	
	public Collection<CaseProduct> findAllCases() {
        return caseProductDao.findAll();
	}
	
	public Collection<CaseProduct> findCasesWithDesign(CaseDesign design) {
        return caseProductDao.findByDesign(design);
	}

	public CaseProductDao getCaseProductDao() {
		return caseProductDao;
	}

	public void setCaseProductDao(CaseProductDao caseProductDao) {
		this.caseProductDao = caseProductDao;
	}

	public CaseProduct findCaseWithDesignAndDevice(String design, String device) {
		return caseProductDao.findByDesignNameAndDeviceName(design, device);
	}

	
	
	
}
