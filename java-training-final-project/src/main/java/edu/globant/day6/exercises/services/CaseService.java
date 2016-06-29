package edu.globant.day6.exercises.services;

import java.util.Collection;

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

	public Case save(Case aCase) {
		log.info("Persisting Case [" + aCase + "] to database...");
		return caseDao.save(aCase);
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

	public Collection<Case> findAllCases() {
		return (Collection<Case>) caseDao.findAll(); 
	}
	
	public Case find(Case c) {
		return caseDao.findOne(c.getId());
	}

}
