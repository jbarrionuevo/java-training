package ilan.dtos;

import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ProviderDTO {
	
//	private Collection<CaseOrderDTO> orders;
//	private Collection<CaseProductDTO> cases;
	private String name,location;
	
	public ProviderDTO(){}
	
	public ProviderDTO(String name,String location){
		this.name=name;
		this.location=location;
//		this.orders = new ArrayList<CaseOrderDTO>();
	}

//	public Collection<CaseOrderDTO> getOrders() {
//		return orders;
//	}
//
//	public void setOrders(Collection<CaseOrderDTO> orders) {
//		this.orders = orders;
//	}
//
//	public Collection<CaseProductDTO> getCases() {
//		return cases;
//	}
//
//	public void setCases(Collection<CaseProductDTO> cases) {
//		this.cases = cases;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
