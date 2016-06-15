package edu.globant.day1.multi_tier_applications.exercices.layers.controllers;

import edu.globant.day1.multi_tier_applications.exercices.layers.services.CaseSellerService;

public class CaseSellerController {
	private CaseSellerService caseSellerService;

	public CaseSellerService getCaseSellerService() {
		return caseSellerService;
	}

	public void setCaseSellerService(CaseSellerService caseSellerService) {
		this.caseSellerService = caseSellerService;
	}
}
