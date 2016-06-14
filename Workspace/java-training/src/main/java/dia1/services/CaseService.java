package dia1.services;

import dia1.daos.CaseDao;
import dia1.models.CaseDesign;
import dia1.models.CaseDevice;
import dia1.models.Logistic;
import dia1.models.Order;
import dia1.models.Provider;

public class CaseService {
	
	private CaseDao caseDao;
	
	public int caseStock(CaseDesign design, CaseDevice device){
		System.out.println("return the number of cases with those parameters");
		return 0;
	}
	
	public void incrementStock(CaseDesign design, CaseDevice device, int quantity){
		System.out.println("update stock for cases with those parameters");
	}
	
	public void decrementStock(CaseDesign design, CaseDevice device, int quantity){
		System.out.println("update stock for cases with those parameters");
	}
	
	public int caseAmountFromProvider(Provider provider){
		System.out.println("return the number of cases provided by a specific provider");
		return 0;
	}

	public CaseDao getCaseDao() {
		return caseDao;
	}

	public void setCaseDao(CaseDao caseDao) {
		this.caseDao = caseDao;
	}
}
