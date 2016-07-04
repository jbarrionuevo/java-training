package edu.globant.IONSolid.services.sale.saleImp;

import java.util.Map;

import edu.globant.IONSolid.model.registry.Registry;
import edu.globant.IONSolid.model.registry.exception.AlreadyExistRegisterException;
import edu.globant.IONSolid.model.registry.exception.NotFoundRegisterException;
import edu.globant.IONSolid.model.sale.Sale;
import edu.globant.IONSolid.model.sale.SaleState;
import edu.globant.IONSolid.services.sale.SaleService;
import edu.globant.IONSolid.services.sale.exception.SaleServiceException;
//import edu.globant.IONSolid.services.warehouse.WarehouseService;

/*
 * When modyfing a sell state it should be updated on the database
 * 
 * */
public class SaleServiceImp implements SaleService {

	// This objects will be injected using spring
	//private WarehouseService warehouseService;
	private Registry<Long, Sale> saleRegistry;

	public SaleServiceImp(/*WarehouseService warehouseService*/) {
	//	this.warehouseService = warehouseService;
		this.saleRegistry = new Registry<Long, Sale>();
	}

	public void registerASaleDraft(Sale sale) throws SaleServiceException {
		try {
			// Inserts a sale without any inventory checking
			this.saleRegistry.insertRegister(sale.getIdSale(), sale);
		} catch (AlreadyExistRegisterException e) {
			// If the sale is registered
			throw new SaleServiceException(
					"Service Sales exception: sale with id:" + sale.getIdSale() + " already exists ", e);
		} catch (Exception e) {
			throw new SaleServiceException("Service Sales throw an exception ", e);
		}
	}

	public Sale getASale(Long saleId) throws SaleServiceException {
		try {
			return this.saleRegistry.getRegister(saleId);
		} catch (NotFoundRegisterException e) {
			throw new SaleServiceException("Service Sales exception: sale with id:" + saleId + " was not found ", e);
		} catch (Exception e) {
			throw new SaleServiceException("Service Sales throw an exception ", e);
		}
	}

	public void registerAPayment(Sale sale) throws SaleServiceException {
		try {
			// If the sale has not already been payed
			if (!sale.getSaleState().equals(SaleState.PAID)) {
				// Check for inventory
				// Decrease Inventory
				sale.setNewSaleState(SaleState.PAID);
				this.saleRegistry.updateRegister(sale.getIdSale(), sale);
			}
		} catch (NotFoundRegisterException e) {
			throw new SaleServiceException(
					"Service Sales exception: sale with id:" + sale.getIdSale() + " was not found ", e);
		} catch (Exception e) {
			throw new SaleServiceException("Service Sales throw an exception ", e);
		}
	}

	public void cancelASale(Sale sale) throws SaleServiceException {
		// If the sale is a a draft
		if (sale.getSaleState().equals(SaleState.DRAFT)) {
			try {
				// Cancel the sale
				sale.setNewSaleState(SaleState.CANCELLED);
				// update the registry sale
				this.saleRegistry.updateRegister(sale.getIdSale(), sale);
			} catch (NotFoundRegisterException e) {
				throw new SaleServiceException(
						"Service Sales exception: sale with id:" + sale.getIdSale() + " was not found ", e);
			} catch (Exception e) {
				throw new SaleServiceException("Service Sales throw an exception ", e);
			}
		}
	}

	public void refundASale(Sale sale) throws SaleServiceException {
		// If the sale is a a draft
		if (sale.getSaleState().equals(SaleState.PAID)) {
			try {
				// Cancel the sale
				sale.setNewSaleState(SaleState.REFUND);
				// Increase Inventory
				// update the registry sale
				this.saleRegistry.updateRegister(sale.getIdSale(), sale);
			} catch (NotFoundRegisterException e) {
				throw new SaleServiceException(
						"Service Sales exception: sale with id:" + sale.getIdSale() + " was not found ", e);
			} catch (Exception e) {
				throw new SaleServiceException("Service Sales throw an exception ", e);
			}
		}
	}

	public Map<Long, Sale> getAllRegisteredSales() {
		return saleRegistry.getAllRegisters();
	}
}
