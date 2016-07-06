package ilan.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(indexes = {@Index(columnList = "name", name = "provider_name")})
public class Provider extends ThirdPartyParticipant implements InventoryObserver{
	
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "provider", cascade = CascadeType.ALL)
	@JsonIgnore
	private Collection<CaseProduct> cases;
	
	
	public Provider(){}
	
	public Provider(String name,String location){
		super(name,location);
	}
	
	@Override
	public String toString(){
		return String.format("Name: %s. Location: %s", this.getName(), this.getLocation());
	}
	
	@Override
	public boolean equals(Object otherCaseDesign){
		Provider other = (Provider)otherCaseDesign;
		return this.getName().equals(other.getName()) && this.getLocation().equals(other.getLocation());
	}

	@Override
	public void doUpdate(CaseProduct aCase) {
		System.out.println("Check if the provider contains aCase; if true,"
				+ "generate an auto-order for provide that case");
	}

	public Collection<CaseProduct> getCases() {
		return cases;
	}

	public void setCases(Collection<CaseProduct> cases) {
		this.cases = cases;
	}

	
}
