package ilan.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ilan.daos.CaseDeviceDao;
import ilan.exceptions.CaseDeviceNotFoundException;
import ilan.models.CaseDevice;

@Service
public class CaseDeviceService {

	private final static Logger log = LoggerFactory.getLogger(CaseDeviceService.class);
	
	@Autowired
	CaseDeviceDao caseDeviceDao;
	
	public CaseDevice saveCaseDevice(CaseDevice newCaseDevice){
		return caseDeviceDao.save(newCaseDevice);
	}
	
	@Transactional
	public void saveCaseDevices(CaseDevice... caseDevices){
		 for (CaseDevice caseDevice: caseDevices) {
	            log.info("Persisting Case Device [" + caseDevice + "] to database...");
	            caseDeviceDao.save(caseDevice);
	     }
	}
	
	public CaseDevice findBy(Long id){
		CaseDevice result = caseDeviceDao.findOne(id);
		if(result==null) throw new CaseDeviceNotFoundException(id);
		return result;
	}
	
	public CaseDevice findByName(String name){
		CaseDevice result = caseDeviceDao.findByName(name);
		if(result==null) throw new CaseDeviceNotFoundException(name);
		return result;
	}
	
}
