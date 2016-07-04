package edu.globant.IONSolid.services;

public class ProviderSearch extends SearchCriteria {

	public enum ProviderSearchCriteria {
		BY_DESIGN, BY_CASE, BY_ID;
	}
	
	private ProviderSearchCriteria type;
	
	public ProviderSearch(ProviderSearchCriteria type) {
		this.type = type;
	}
	
	public ProviderSearchCriteria getCriteria() {
		return this.type;
	}
}
