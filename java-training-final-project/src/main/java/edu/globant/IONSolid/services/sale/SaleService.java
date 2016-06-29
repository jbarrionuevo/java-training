package edu.globant.IONSolid.services.sale;

import edu.globant.IONSolid.model.registry.Registry;
import edu.globant.IONSolid.model.registry.sale.SaleRegistry;
import edu.globant.IONSolid.model.sale.Sale;
import edu.globant.IONSolid.model.sale.SaleState;
import edu.globant.IONSolid.services.warehouse.WarehouseService;

public class SaleService {

	private WarehouseService warehouseService;
	private Registry<Long, Sale> saleRegistry;
	
	public SaleService(WarehouseService warehouseService, SaleRegistry saleRegistry) {
		this.warehouseService = warehouseService;
		this.saleRegistry = saleRegistry;
	}
	
	public void registerASale(Sale sale) {
		//If the sale is not registered
		if(!this.saleRegistry.isRegisterRegistered(sale)) {
			this.saleRegistry.insertRegister(sale);
		}
		else {
			//rise exception
		}
	}
	
	public Sale getASale(Long saleId) {
		return this.saleRegistry.getRegister(saleId);
	}
	
	public void registerAPaid(Sale sale) {
		//If the sale is registered
		if(this.saleRegistry.isRegisterRegistered(sale)) {
			//Check for inventory
			//Decrease Inventory
			sale.setNewSaleState(SaleState.PAID);
			this.saleRegistry.updateRegister(sale);
		}
		else {
			//rise exception
		}
	}
	
	public void cancelASale(Sale sale) {
		//If the sale is registered
		if(this.saleRegistry.isRegisterRegistered(sale)) {
			//Increase Inventory
			sale.setNewSaleState(SaleState.CANCELLED);
			this.saleRegistry.updateRegister(sale);
		}
		else {
			//rise exception
		}		
	}
	
	public void refundASale(Sale sale) {
		
	}
	
	
}
