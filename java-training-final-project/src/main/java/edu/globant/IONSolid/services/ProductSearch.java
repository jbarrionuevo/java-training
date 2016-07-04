package edu.globant.IONSolid.services;

public class ProductSearch extends SearchCriteria {

	public enum ProductSearchCriteria {
		BY_DESIGN, BY_CASE, BY_ID;
	}
	
	private ProductSearchCriteria searchType;
	
	public ProductSearch(ProductSearchCriteria type) {
		this.searchType = type;
	}
	
	public ProductSearchCriteria getSearchType() {
		return this.searchType;
	}
}
