package edu.globant.IONSolid.model.cases;

public class ProductCase {

	// unique id for every product
	private Long caseProductId;
	private Double unitPrice;
	private String name;
	private CaseDevice device;
	private CaseDesign design;
	private Integer currentProductStock;

	public ProductCase(Long itemId, String name, CaseDevice device, CaseDesign design, Double price, Integer stock) {
		this.caseProductId = itemId;
		this.unitPrice = price;
		this.device = device;
		this.design = design;
		this.currentProductStock = 0;
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
