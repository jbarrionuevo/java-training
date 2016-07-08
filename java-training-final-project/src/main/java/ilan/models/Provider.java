package ilan.models;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(indexes = {@Index(columnList = "name", name = "provider_name")})
public class Provider extends ThirdPartyParticipant {
	
	
//	@OneToMany(fetch = FetchType.EAGER, mappedBy = "provider", cascade = CascadeType.ALL)
//	@JsonIgnore
//	private Collection<CaseProduct> cases;
	
	
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

//	public Collection<CaseProduct> getCases() {
//		return cases;
//	}
//
//	public void setCases(Collection<CaseProduct> cases) {
//		this.cases = cases;
//	}

	
}
