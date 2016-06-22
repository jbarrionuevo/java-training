package exercices.day6.dependency_injection.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exercices.day6.dependency_injection.daos.CaseDao;
import exercices.day6.dependency_injection.daos.CaseSellerDao;
import exercices.day6.dependency_injection.models.Case;
import hello.BookingService;

@Service
public class CaseService {
	
	private final static Logger log = LoggerFactory.getLogger(BookingService.class);
	
	@Autowired
	CaseDao caseDao;
	
	public void saveCase(Case newCase){
	    caseDao.save(newCase);
	}
}
