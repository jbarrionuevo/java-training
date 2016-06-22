package exercices.day6.dependency_injection.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exercices.day6.dependency_injection.daos.CaseDesignDao;
import exercices.day6.dependency_injection.daos.CaseDeviceDao;
import exercices.day6.dependency_injection.models.CaseDesign;
import exercices.day6.dependency_injection.models.CaseDevice;

@Service
public class CaseDeviceService {

	@Autowired
	CaseDeviceDao caseDeviceDao;
	
	public void saveCase(CaseDevice newCaseDevice){
		caseDeviceDao.save(newCaseDevice);
	}
}
