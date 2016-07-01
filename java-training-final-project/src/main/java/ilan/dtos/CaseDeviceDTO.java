package ilan.dtos;

import java.util.ArrayList;
import java.util.Collection;

import org.thymeleaf.util.Validate;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CaseDeviceDTO {
	private Long id;
	private String name;
//	@JsonIgnore
//	private Collection<CaseProductDTO> cases;
	
	public CaseDeviceDTO(){}
	
	public CaseDeviceDTO(String name) {
		Validate.notEmpty(name, "Name cannot be blank");
		this.name = name;
//		this.cases=new ArrayList<CaseProductDTO>();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public Collection<CaseProductDTO> getCases() {
//		return cases;
//	}
//
//	public void setCases(Collection<CaseProductDTO> cases) {
//		this.cases = cases;
//	}

	
}
