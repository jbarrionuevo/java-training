package edu.globant.day6.exercises.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.globant.day6.exercises.DAO.CaseDAO;
import edu.globant.day6.exercises.model.Case;

@Service
public class CaseService {

	private final static Logger log = LoggerFactory.getLogger(CaseService.class);

	@Autowired
	CaseDAO caseDao;

	public void saveCase(Case newCase) {
		caseDao.save(newCase);
	}

	@Transactional
	public void saveCases(Case... cases) {
		for (Case aCase : cases) {
			log.info("Persisting Case [" + aCase + "] to database...");
			caseDao.save(aCase);
		}
	}

	public CaseDAO getCaseDao() {
		return caseDao;
	}

	public void setCaseDao(CaseDAO caseDao) {
		this.caseDao = caseDao;
	}

}
