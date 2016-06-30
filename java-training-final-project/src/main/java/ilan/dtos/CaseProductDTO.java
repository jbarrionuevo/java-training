package ilan.dtos;

import org.thymeleaf.util.Validate;

public class CaseProductDTO {
	private Long id;
	private CaseDesignDTO design;
	private CaseDeviceDTO device;
	private double price;
	private ProviderDTO provider;
	
	public CaseProductDTO(){}
	
	public CaseProductDTO(CaseDesignDTO design, CaseDeviceDTO device, Double price, ProviderDTO provider) {
		Validate.notNull(design, "Design cannot be null");
		Validate.notNull(device,"Device cannot be null");
		Validate.notNull(provider,"Provider cannot be null");
		Validate.notNull(price,"Price cannot be null");
		this.design = design;
		this.device = device;
		this.price=price;
		this.provider=provider;
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CaseDesignDTO getDesign() {
		return design;
	}

	public void setDesign(CaseDesignDTO design) {
		this.design = design;
	}

	public CaseDeviceDTO getDevice() {
		return device;
	}

	public void setDevice(CaseDeviceDTO device) {
		this.device = device;
	}

	public ProviderDTO getProvider() {
		return provider;
	}

	public void setProvider(ProviderDTO provider) {
		this.provider = provider;
	}


}
