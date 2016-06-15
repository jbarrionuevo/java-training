package edu.globant.day1.multi_tier_applications.exercices.structure.controllers;

import edu.globant.day1.multi_tier_applications.exercices.structure.services.CaseSellerService;

public class CaseSellerController {
	private CaseSellerService caseSellerService;

	public CaseSellerService getCaseSellerService() {
		return caseSellerService;
	}

	public void setCaseSellerService(CaseSellerService caseSellerService) {
		this.caseSellerService = caseSellerService;
	}
}
