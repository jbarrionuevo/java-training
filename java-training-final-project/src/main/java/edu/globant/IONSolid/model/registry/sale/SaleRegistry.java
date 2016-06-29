package edu.globant.IONSolid.model.registry.sale;

import java.util.HashMap;
import java.util.Map;

import edu.globant.IONSolid.model.registry.Registry;
import edu.globant.IONSolid.model.registry.exception.AlreadyExistRegisterException;
import edu.globant.IONSolid.model.registry.exception.NotFoundRegisterException;
import edu.globant.IONSolid.model.sale.Sale;

public class SaleRegistry implements Registry<Long, Sale> {

	private Map<Long, Sale> saleRegistry;
	
	public SaleRegistry() {
		this.saleRegistry = new HashMap<Long, Sale>();
	}
	
	@Override
	public Sale getRegister(Long saleId) throws NotFoundRegisterException {
		if(isRegisterRegisteredById(saleId)) {
			return this.saleRegistry.get(saleId);
		} 
		else {
			throw new NotFoundRegisterException("The sale: " + saleId + " was not found");
		}
	}

	@Override
	public void insertRegister(Sale sale) throws AlreadyExistRegisterException {
		if(!isRegisterRegistered(sale)) {
			//Inserts new Sale
			this.saleRegistry.put(sale.getIdSale(), sale);
		}
		else {
			throw new AlreadyExistRegisterException("The sale: " + sale.getIdSale() + " already exists");
		}		
	}

	@Override
	public void updateRegister(Sale sale) throws NotFoundRegisterException {
		if(isRegisterRegistered(sale)) {
			//Overrides old sale
			this.saleRegistry.put(sale.getIdSale(), sale);
		}
		else {
			throw new NotFoundRegisterException("The sale: " + sale.getIdSale() + " was not found");
		}		
	}

	@Override
	public boolean isRegisterRegistered(Sale sale) {
		return this.isRegisterRegisteredById(sale.getIdSale()); 
	}
	
	@Override
	public boolean isRegisterRegisteredById(Long saleId) {
		return this.saleRegistry.containsKey(saleId); 

	}

	@Override
	public Map<Long, Sale> getAllRegisters() {
		return this.saleRegistry;
	}
}
