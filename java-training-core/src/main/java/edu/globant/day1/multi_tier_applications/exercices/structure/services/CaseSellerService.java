package edu.globant.day1.multi_tier_applications.exercices.structure.services;

import java.util.Collection;

import edu.globant.day1.oop.exercices.daos.CaseSellerDao;
import edu.globant.day1.oop.exercices.models.CaseSeller;
import edu.globant.day1.oop.exercices.models.Order;
import edu.globant.day1.oop.exercices.models.Sale;

public class CaseSellerService {
	
	private CaseSellerDao caseSellerDao;
	
	public CaseSellerDao getCaseSellerDao() {
		return caseSellerDao;
	}

	public void setCaseSellerDao(CaseSellerDao caseSellerDao) {
		this.caseSellerDao = caseSellerDao;
	}
	
}
