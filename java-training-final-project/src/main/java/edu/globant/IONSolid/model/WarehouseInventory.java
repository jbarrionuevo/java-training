package edu.globant.IONSolid.model;

import java.util.HashMap;
import java.util.Map;

import edu.globant.IONSolid.model.productcases.*;
import edu.globant.IONSolid.services.warehouse.exception.NotFoundProductException;

public class WarehouseInventory {

	private Map<Long, ProductStock> warehouseProducts;
	private static WarehouseInventory instance; 
	
	private WarehouseInventory() {
		warehouseProducts = new HashMap<Long, ProductStock>();
	}
	
	public static WarehouseInventory getInstance() {
		if(instance == null) {
			return new WarehouseInventory();
		}
		return instance;
	}
	
	public void addProductToStock
	public void increaseProductCaseStock(ProductCase product, Integer quantity) {
		
	}
	
	public void decreaseProductCaseStock(ProductCase product, Integer quantity) {
		//If the product exists
		if(this.existsProductId(product.getCaseProductId())) {
			ProductStock p = this.warehouseProducts.get(product.getCaseProductId());
			//If the stock is bigger than 0
			if(this.isProductCaseDecreaseAllow(product, quantity)) {
				this.w
			}
			return false;
		}
		throw new NotFoundProductException("The product with id: " + product.getCaseProductId() + " was not found");
	}
	
	private boolean isProductCaseDecreaseAllow(ProductCase product, Integer quantity) throws NotFoundProductException {
		//If the product exists
		if(this.existsProductId(product.getCaseProductId())) {
			ProductStock p = this.warehouseProducts.get(product.getCaseProductId());  
			if(p.getCurrentProductStock() - quantity >= 0) {
				return true;
			}
			return false;
		}
		throw new NotFoundProductException("The product with id: " + product.getCaseProductId() + " was not found");	
	}
	
	public boolean isProductCaseOnStock(ProductCase product) throws NotFoundProductException {
		//If the product exists
		if(this.existsProductId(product.getCaseProductId())) {
			ProductStock p = this.warehouseProducts.get(product.getCaseProductId());
			//If the stock is bigger than 0
			if(p.getCurrentProductStock() > 0) {
				return true;
			}
			return false;
		}
		throw new NotFoundProductException("The product with id: " + product.getCaseProductId() + " was not found");
	}
	
	private boolean existsProductId(Long productId) {
		return this.warehouseProducts.containsKey(productId);
	}
}
