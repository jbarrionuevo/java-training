package ilan.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.thymeleaf.util.Validate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(indexes = {@Index(columnList = "name", name = "case_design_name")})
public class CaseDesign implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	private String name;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "design", cascade = CascadeType.ALL)
	@JsonIgnore
	private Collection<CaseProduct> cases;
	
	public CaseDesign(){}
	
	public CaseDesign(String name) {
		Validate.notEmpty(name, "Name cannot be blank");
		this.name = name;
		this.cases=new ArrayList<CaseProduct>();
	}

	@Override
	public String toString(){
		return String.format("Name: %s", this.getName());
	}
	
	@Override
	public boolean equals(Object otherCaseDesign){
		CaseDesign other = (CaseDesign)otherCaseDesign;
		return this.getName().equals(other.getName());
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
