package edu.globant.IONSolid.services;

import java.util.HashMap;
import java.util.Map;

import edu.globant.IONSolid.model.sale.Sale;

public class SaleRegistry implements Registry<Sale> {

	private Map<Long, Sale> saleRegistry;
	
	public SaleRegistry() {
		this.saleRegistry = new HashMap<Long, Sale>();
	}
	
	@Override
	public Sale getRegister(Long id) {
		if(this.saleRegistry.containsKey(id)) {
			return this.saleRegistry.get(id);
		} 
		else {
			//Should return an exception for not found
			//sale
			return null;
		}
	}

	@Override
	public void insertRegister(Sale sale) {
		if(!this.saleRegistry.containsKey(sale.getIdSale())) {
			this.saleRegistry.put(sale.getIdSale(), sale);
		}
		else {
			//Should return an exception for already exist sale
		}		
	}

	@Override
	public void updateRegister(Sale sale) {
		if(isRegisterRegistered(sale)) {
			this.saleRegistry.put(sale.getIdSale(), sale);
		}
		else {
			//Should return an exception
		}		
	}

	@Override
	public boolean isRegisterRegistered(Sale sale) {
		return this.saleRegistry.containsKey(sale); 
	}
}
