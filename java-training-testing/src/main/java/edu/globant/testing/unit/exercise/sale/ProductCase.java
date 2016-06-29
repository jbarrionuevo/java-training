package edu.globant.testing.unit.exercise.sale;

import org.apache.commons.lang3.Validate;

public class ProductCase {

	// unique id for every product
	private Long caseProductId;
	private Double unitPrice;
	private String name;
	private CaseDevice device;
	private CaseDesign design;
	private Integer currentProductStock;

	public ProductCase(Long caseProductId, String name, CaseDevice device, CaseDesign design, Double price, Integer stock) {
		this.validateArguments(caseProductId, name, device, design, price, stock);
		this.caseProductId = caseProductId;
		this.name = name;
		this.unitPrice = price;
		this.device = device;
		this.design = design;
		this.currentProductStock = 0;
	}

	private void validateArguments(Long caseProductId, String name, CaseDevice device, CaseDesign design, Double price, Integer stock) {
		Validate.notNull(caseProductId, "Id can not be null");		
        Validate.notBlank(name, "The name cannot be blank.");
		Validate.notNull(device, "device can not be null");		
		Validate.notNull(design, "design can not be null");		
        Validate.isTrue(price > 0, "The price must be greater than zero");
        Validate.isTrue(stock > 0, "The stock must be greater than zero");
	}
	/*
	 * For simplicity I will assume that the prices won't change. If the
	 * requirements change perhaps it would be necessary to create a new object
	 * to handle the changing prices
	 */
	public Double getUnitPrice() {
		return unitPrice;
	}

	public Long getCaseProductId() {
		return caseProductId;
	}

	public String getName() {
		return name;
	}

	public CaseDevice getDevice() {
		return device;
	}

	public CaseDesign getDesign() {
		return design;
	}

	public Integer getCurrentProductStock() {
		return currentProductStock;
	}
}
