package edu.globant.IONSolid.services.warehouse.warehouseImp;

import java.util.List;

import edu.globant.IONSolid.model.inventory.Inventory;
import edu.globant.IONSolid.model.inventory.exception.NoStockException;
import edu.globant.IONSolid.model.productcases.*;
import edu.globant.IONSolid.model.registry.exception.AlreadyExistRegisterException;
import edu.globant.IONSolid.model.registry.exception.NotFoundRegisterException;
import edu.globant.IONSolid.services.SearchCriteria;
import edu.globant.IONSolid.services.warehouse.WarehouseInventoryService;
import edu.globant.IONSolid.services.warehouse.exception.WarehouseInventoryServiceException;

public class WarehouseInventoryServiceImp implements WarehouseInventoryService {

	private Inventory inventory;
	// This class should have its dao

	public WarehouseInventoryServiceImp() {
		inventory = new Inventory();
	}

	@Override
	public void addProductItemToInventory(ProductCase product, Integer stock) throws WarehouseInventoryServiceException {
		try {
			inventory.addProductToInventory(product);
		} catch (AlreadyExistRegisterException e) {
			throw new WarehouseInventoryServiceException("Service Warehouse Inventory exception: product with id:"
					+ product.getCaseProductId() + " already exists ", e);
		}
	}

	@Override
	public void increaseProductCaseStock(ProductCase product, Integer quantity)
			throws WarehouseInventoryServiceException {
		try {
			this.inventory.increaseProductCaseStock(product, quantity);
		} catch (NotFoundRegisterException e) {
			throw new WarehouseInventoryServiceException(
					"The product with id: " + product.getCaseProductId() + " was not found", e);
		}
	}

	@Override
	public void decreaseProductCaseStock(ProductCase product, Integer quantity)
			throws WarehouseInventoryServiceException, NoStockException {
		try {
			inventory.decreaseProductCaseStock(product, quantity);
		} catch (NotFoundRegisterException e) {
			throw new WarehouseInventoryServiceException(
					"The product with id: " + product.getCaseProductId() + " was not found", e);
		}
	}

	@Override
	public Integer searchProductAmount(SearchCriteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductCase> searchProduct(SearchCriteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductCase getProduct(Long productId) {
		// TODO Auto-generated method stub
		return null;
	}
}
