package edu.globant.IONSolid.model.sale;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import edu.globant.IONSolid.model.Customer;
import edu.globant.IONSolid.model.cases.ProductCase;
import edu.globant.IONSolid.model.employee.Employee;
import edu.globant.IONSolid.model.sale.exception.NotFoundProductDetailException;
import edu.globant.IONSolid.model.sale.exception.SaleModificationException;

public class Sale {

	private Long idSale;
	private Employee seller;
	private SaleState saleState;
	private Date saleCreationDate;
	private Customer saleCustomer;
	private List<SaleProductDetail> saleProductDetails;

	public Sale(Long idSale, Employee saleEmployee, Customer saleCustomer) {
		this.idSale = idSale;
		this.seller = saleEmployee;
		this.saleState = SaleState.DRAFT;
		// set with the date of the draft creation
		this.saleCreationDate = new Date();
		this.saleProductDetails = new ArrayList<SaleProductDetail>();
		this.saleCustomer = saleCustomer;
	}

	public void setNewSaleState(SaleState newState) {
		if (newState.equals(SaleState.PAID)) {
			// Override the draft creation date with the payment one
			saleCreationDate = new Date();
		}
		this.saleState = newState;
	}

	public Double getSaleTotal() {
		return saleProductDetails.stream().
				mapToDouble(s -> s.getTotalPrice()).sum();
	}

	public void addProducts(ProductCase newProduct, Integer quantity) throws SaleModificationException {
		// If the sale is a draft, new products are allow
		if (this.saleState.equals(SaleState.DRAFT)) {
			addSaleDetail(newProduct, quantity);
		} else {
			throw new SaleModificationException("Modifications for this sale are not allow. State: " + this.saleState);
		}
	}

	public SaleProductDetail getSaleProductDetail(ProductCase newProduct) {
		for (SaleProductDetail s : this.saleProductDetails) {
			boolean cond = s.getProductCase().getCaseProductId().equals(newProduct.getCaseProductId());
			if (cond) {
				return s;
			}
		}
		return null;
	}

	private void addSaleDetail(ProductCase newProduct, Integer quantity) {
		SaleProductDetail detail = getSaleProductDetail(newProduct);
		// If the detail for the product exists
		if (detail != null) {
			detail.setProductQuantity(detail.getProductQuantity() + quantity);
		} else {
			saleProductDetails.add(new SaleProductDetail(newProduct, quantity));
		}
	}

	public void removeSaleDetail(ProductCase product) throws SaleModificationException {
		// If the sale is a draft, to remove products is allow
		if (this.saleState.equals(SaleState.DRAFT)) {
			saleProductDetails.removeIf(s -> s.getProductCase().
					getCaseProductId().equals(product.getCaseProductId()));
		} else {
			throw new SaleModificationException("Modifications for this sale are not allow. State: " + this.saleState);
		}
	}

	public void removeSaleProducts(ProductCase product, Integer quantity)
			throws NotFoundProductDetailException, SaleModificationException {
		SaleProductDetail detail;
		// If the sale is a draft, to remove products is allow
		if (this.saleState.equals(SaleState.DRAFT)) {
			detail = getSaleProductDetail(product);
			if (detail != null) {
				detail.setProductQuantity(detail.getProductQuantity() - quantity);
			} else {
				throw new NotFoundProductDetailException("The product detail was not found for this product");
			}

		} else {
			throw new SaleModificationException("Modifications for this sale are not allow. State: " + this.saleState);
		}
	}
	
	public List<SaleProductDetail> getSaleDetails() {
		return saleProductDetails.stream().collect(Collectors.toList());
	}

	public Long getIdSale() {
		return idSale;
	}
	
	public Customer getCustomer() {
		return this.saleCustomer;
	}

	public Employee getSeller() {
		return seller;
	}

	public SaleState getSaleState() {
		return saleState;
	}

	public Date getSaleCreationDate() {
		return this.saleCreationDate;
	}
}
