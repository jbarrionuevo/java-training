package exercices.day6.dependency_injection.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import exercices.day6.dependency_injection.daos.CaseDesignDao;
import exercices.day6.dependency_injection.daos.CaseDeviceDao;
import exercices.day6.dependency_injection.models.Case;
import exercices.day6.dependency_injection.models.CaseDesign;
import exercices.day6.dependency_injection.models.CaseDevice;

@Service
public class CaseDeviceService {

	private final static Logger log = LoggerFactory.getLogger(CaseDeviceService.class);
	
	@Autowired
	CaseDeviceDao caseDeviceDao;
	
	public void saveCaseDevice(CaseDevice newCaseDevice){
		caseDeviceDao.save(newCaseDevice);
	}
	
	@Transactional
	public void saveCaseDevices(CaseDevice... caseDevices){
		 for (CaseDevice caseDevice: caseDevices) {
	            log.info("Persisting Case Device [" + caseDevice + "] to database...");
	            caseDeviceDao.save(caseDevice);
	     }
	}
	
	public CaseDevice findBy(Long id){
		return caseDeviceDao.findOne(id);
	}
	
	public CaseDevice findByName(String name){
		return caseDeviceDao.findByName(name);
	}
	
}
