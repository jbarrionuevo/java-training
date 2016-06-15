package edu.globant.day1.multi_tier_applications.exercices.structure.controllers;

import edu.globant.day1.multi_tier_applications.exercices.structure.services.SaleService;

public class SaleController {
	private SaleService saleService;

	public SaleService getSaleService() {
		return saleService;
	}

	public void setSaleService(SaleService saleService) {
		this.saleService = saleService;
	}
}
