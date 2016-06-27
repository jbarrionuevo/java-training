package ilan.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ilan.daos.CaseDesignDao;
import ilan.models.CaseDesign;


@Service
public class CaseDesignService {
	
	private final static Logger log = LoggerFactory.getLogger(CaseDesignService.class);
	
	@Autowired
	CaseDesignDao caseDesignDao;
	
	public void saveCaseDesign(CaseDesign newCaseDesign){
		caseDesignDao.save(newCaseDesign);
	}
	
	@Transactional
	public void saveCaseDesigns(CaseDesign... caseDesigns){
		 for (CaseDesign caseDesign: caseDesigns) {
	            log.info("Persisting Case Design [" + caseDesign + "] to database...");
	            caseDesignDao.save(caseDesign);
	     }
	}
}
