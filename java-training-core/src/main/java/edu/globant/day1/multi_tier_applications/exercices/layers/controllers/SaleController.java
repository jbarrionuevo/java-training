package edu.globant.day1.multi_tier_applications.exercices.layers.controllers;

import edu.globant.day1.multi_tier_applications.exercices.layers.services.SaleService;

public class SaleController {
	private SaleService saleService;

	public SaleService getSaleService() {
		return saleService;
	}

	public void setSaleService(SaleService saleService) {
		this.saleService = saleService;
	}
}
