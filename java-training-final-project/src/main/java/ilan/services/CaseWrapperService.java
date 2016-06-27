package ilan.services;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ilan.daos.CaseWrapperDao;
import ilan.models.CaseOrder;
import ilan.models.CaseWrapper;

@Service
public class CaseWrapperService {
	private final static Logger log = LoggerFactory.getLogger(CaseWrapperService.class);

	@Autowired
	private CaseWrapperDao caseWrapperDao;
	
	public void saveCaseWrapper(CaseWrapper caseWrapper){
		caseWrapperDao.save(caseWrapper);
	}
	
	@Transactional
	public void saveCaseWrappers(CaseWrapper...caseWrappers){
		for(CaseWrapper wrapper: caseWrappers){
			caseWrapperDao.save(wrapper);
		}
	}
}
