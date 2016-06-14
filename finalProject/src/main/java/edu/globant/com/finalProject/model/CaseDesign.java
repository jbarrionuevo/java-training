package edu.globant.com.finalProject.model;

public class CaseDesign {
	
	private int id;
	private String designName;
	
	public CaseDesign() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesignName() {
		return designName;
	}

	public void setDesignName(String designName) {
		this.designName = designName;
	}

	@Override
	public String toString() {
		return "CaseDesign [id=" + id + ", designName=" + designName + "]";
	}
	
}
