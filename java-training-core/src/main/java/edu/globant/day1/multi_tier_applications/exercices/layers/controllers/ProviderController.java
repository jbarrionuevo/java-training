package edu.globant.day1.multi_tier_applications.exercices.layers.controllers;

import edu.globant.day1.multi_tier_applications.exercices.layers.services.ProviderService;

public class ProviderController {
	private ProviderService providerService;

	public ProviderService getProviderService() {
		return providerService;
	}

	public void setProviderService(ProviderService providerService) {
		this.providerService = providerService;
	}
}
