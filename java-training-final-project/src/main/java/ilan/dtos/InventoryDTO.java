package ilan.dtos;

import java.util.ArrayList;
import java.util.Collection;

import ilan.models.CaseWrapper;

public class InventoryDTO {
	private Long id;
	private Collection<CaseWrapperDTO> stock;
	
	private InventoryDTO() {
		this.stock = new ArrayList<CaseWrapperDTO>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Collection<CaseWrapperDTO> getStock() {
		return stock;
	}

	public void setStock(Collection<CaseWrapperDTO> stock) {
		this.stock = stock;
	}
	
	
}
