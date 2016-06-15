package edu.globant.day1.exercises.ddd;

public class Device {

	private int id;
	private String brand;
	private String model;
	private String type = DeviceTypeEnum.CELLPHONE.getDeviceType();
	
	public Device(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Device [id=" + id + ", brand=" + brand + ", model=" + model + ", type=" + type + "]";
	}
	
	

}
