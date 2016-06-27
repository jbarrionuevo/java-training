package edu.globant.IONSolid.model.cases;

public class Case {
	
	private String name;
	private CaseDevice device;
	private CaseDesign design;
	
	public Case(String name, CaseDevice device, CaseDesign design) {
		this.name = name;
		this.device = device;
		this.design = design;
	}

	public CaseDesign getDesign() {
		return design;
	}

	public void addDesign(CaseDesign design) {
		this.design = design;
	}

	public String getName() {
		return name;
	}

	public CaseDevice getDevice() {
		return device;
	}
}
