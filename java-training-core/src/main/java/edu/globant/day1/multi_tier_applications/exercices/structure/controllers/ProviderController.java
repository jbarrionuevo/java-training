package edu.globant.day1.multi_tier_applications.exercices.structure.controllers;

import edu.globant.day1.multi_tier_applications.exercices.structure.services.ProviderService;

public class ProviderController {
	private ProviderService providerService;

	public ProviderService getProviderService() {
		return providerService;
	}

	public void setProviderService(ProviderService providerService) {
		this.providerService = providerService;
	}
}
