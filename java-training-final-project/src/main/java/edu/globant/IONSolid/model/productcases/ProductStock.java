package edu.globant.IONSolid.model.productcases;

public class ProductStock {

	private ProductCase productDetail;
	private Integer currentProductStock;
	
	public ProductStock(ProductCase product, Integer stock) {
		this.productDetail = product;
		this.currentProductStock = stock;
	}

	public ProductCase getProductDetail() {
		return productDetail;
	}

	public Integer getCurrentProductStock() {
		return currentProductStock;
	}
	
	public void increaseStock(Integer stock) {
		this.currentProductStock =  this.currentProductStock + stock;
	}
	
	public void decreaseStock(Integer stock) {
		this.currentProductStock =  this.currentProductStock - stock;
	}
}
