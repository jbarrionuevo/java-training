package ilan.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.thymeleaf.util.Validate;

@Entity
public class CaseDevice implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "device", cascade = CascadeType.ALL)
	private Collection<CaseProduct> cases;
	
	public CaseDevice(){}
	
	@Override
	public String toString(){
		return String.format("Name: %s", this.getName());
	}
	
	public CaseDevice(String name) {
		Validate.notEmpty(name, "Name cannot be blank");
		this.name = name;
		this.cases=new ArrayList<CaseProduct>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<CaseProduct> getCases() {
		return cases;
	}

	public void setCases(Collection<CaseProduct> cases) {
		this.cases = cases;
	}

	

	
	
	
	
}
