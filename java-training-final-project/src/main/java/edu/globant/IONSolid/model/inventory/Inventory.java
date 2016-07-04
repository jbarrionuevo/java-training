package edu.globant.IONSolid.model.inventory;

import edu.globant.IONSolid.model.inventory.exception.NoStockException;
import edu.globant.IONSolid.model.productcases.ProductCase;
import edu.globant.IONSolid.model.productcases.ProductStock;
import edu.globant.IONSolid.model.registry.Registry;
import edu.globant.IONSolid.model.registry.exception.AlreadyExistRegisterException;
import edu.globant.IONSolid.model.registry.exception.NotFoundRegisterException;

public class Inventory {

	private Registry<Long, ProductCase> inventoryRegistry;

	public Inventory() {
		inventoryRegistry = new Registry<Long, ProductCase>();
	}

	public void addProductToInventory(ProductCase product) throws AlreadyExistRegisterException {
		try {
			inventoryRegistry.insertRegister(product.getCaseProductId(), product);
		} catch (AlreadyExistRegisterException e) {
			throw new AlreadyExistRegisterException(
					"Product with id:" + product.getCaseProductId() + " already exists ", e);
		}
	}

	public void increaseProductCaseStock(ProductCase product, Integer quantity) throws NotFoundRegisterException {
		// If the product exists
		if (this.existsProductId(product.getCaseProductId())) {
			try {
				ProductStock p = product.getProductDetail();
				p.increaseStock(quantity);
				this.inventoryRegistry.updateRegister(product.getCaseProductId(), product);
			} catch (NotFoundRegisterException e) {
				throw new NotFoundRegisterException(
						"The product with id: " + product.getCaseProductId() + " was not found", e);
			}
		}
		throw new NotFoundRegisterException("The product with id: " + product.getCaseProductId() + " was not found");
	}

	public void decreaseProductCaseStock(ProductCase product, Integer quantity)
			throws NotFoundRegisterException, NoStockException {
		// If the product exists
		if (this.existsProductId(product.getCaseProductId())) {
			try {
				ProductStock p = product.getProductDetail();
				// If the stock is bigger than 0
				if (this.isProductCaseDecreaseAllow(product, quantity)) {
					p.decreaseStock(quantity);
					this.inventoryRegistry.updateRegister(product.getCaseProductId(), product);
				} else {
					throw new NoStockException("The product with id: " + product.getCaseProductId() + " has no stock");
				}
			} catch (NotFoundRegisterException e) {
				throw new NotFoundRegisterException(
						"The product with id: " + product.getCaseProductId() + " was not found", e);
			}
		}
		throw new NotFoundRegisterException("The product with id: " + product.getCaseProductId() + " was not found");
	}

	private boolean isProductCaseDecreaseAllow(ProductCase product, Integer quantity) {
		// If the product exists
		if (this.existsProductId(product.getCaseProductId())) {
			ProductStock p = product.getProductDetail();
			if (p.getCurrentProductStock() - quantity >= 0) {
				return true;
			}
			return false;
		}
		return false;
	}

	public boolean hasProductCaseStock(ProductCase product) {
		// If the product exists
		if (this.existsProductId(product.getCaseProductId())) {
			ProductStock p = product.getProductDetail();
			if (p.getCurrentProductStock() > 0) {
				return true;
			}
			return false;
		}
		return false;
	}

	private boolean existsProductId(Long productId) {
		return this.inventoryRegistry.isRegisterRegistered(productId);
	}
}
