package edu.globant.IONSolid.services.warehouse;

import java.util.List;

import edu.globant.IONSolid.model.inventory.exception.NoStockException;
import edu.globant.IONSolid.model.productcases.ProductCase;
import edu.globant.IONSolid.services.SearchCriteria;
import edu.globant.IONSolid.services.warehouse.exception.WarehouseInventoryServiceException;

public interface WarehouseInventoryService {

	public void addProductItemToInventory(ProductCase product, Integer stock) throws WarehouseInventoryServiceException;

	public ProductCase getProduct(Long productId);
	
	public void increaseProductCaseStock(ProductCase product, Integer quantity)
			throws WarehouseInventoryServiceException;

	public void decreaseProductCaseStock(ProductCase product, Integer quantity)
			throws WarehouseInventoryServiceException, NoStockException;

	public Integer searchProductAmount(SearchCriteria criteria);
	
	public List<ProductCase> searchProduct(SearchCriteria criteria);
	
}
