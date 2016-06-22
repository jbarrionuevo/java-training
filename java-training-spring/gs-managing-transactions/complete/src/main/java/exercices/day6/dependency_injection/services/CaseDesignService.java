package exercices.day6.dependency_injection.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exercices.day6.dependency_injection.daos.CaseDao;
import exercices.day6.dependency_injection.daos.CaseDesignDao;
import exercices.day6.dependency_injection.models.Case;
import exercices.day6.dependency_injection.models.CaseDesign;
import hello.BookingService;

@Service
public class CaseDesignService {
private final static Logger log = LoggerFactory.getLogger(BookingService.class);
	
	@Autowired
	CaseDesignDao caseDesignDao;
	
	public void saveCase(CaseDesign newCaseDesign){
		caseDesignDao.save(newCaseDesign);
	}
}
