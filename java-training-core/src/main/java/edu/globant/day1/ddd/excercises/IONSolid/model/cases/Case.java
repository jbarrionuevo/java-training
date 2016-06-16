package edu.globant.day1.ddd.excercises.IONSolid.model.cases;

public class Case {

	private String name;
	private String design;
	private String device;
	
	public Case(String name, String design, String devide) {
		this.setName(name);
		this.setDesign(design);
		this.setDevice(devide);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesign() {
		return design;
	}

	public void setDesign(String design) {
		this.design = design;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}
}
