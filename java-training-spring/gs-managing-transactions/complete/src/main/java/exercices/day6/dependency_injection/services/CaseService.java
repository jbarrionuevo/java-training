package exercices.day6.dependency_injection.services;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import exercices.day6.dependency_injection.daos.CaseDao;
import exercices.day6.dependency_injection.daos.CaseSellerDao;
import exercices.day6.dependency_injection.models.Case;
import exercices.day6.dependency_injection.models.Order;
import hello.BookingService;

@Service
public class CaseService{
	
	private final static Logger log = LoggerFactory.getLogger(CaseService.class);
	
	@Autowired
	CaseDao caseDao;
	
	public void saveCase(Case newCase){
	    caseDao.save(newCase);
	}
	
	@Transactional
	public void saveCases(Case... cases){
		 for (Case aCase: cases) {
	            log.info("Persisting Case [" + aCase + "] to database...");
	            caseDao.save(aCase);
	     }
	}
	
	public Collection<Case> findAllCases() {
        return caseDao.findAll();
	}
}
