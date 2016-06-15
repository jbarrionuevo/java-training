package edu.globant.day1.layersandtiers.exercises.model;

import edu.globant.day1.oop.exercises.Provider.Provider;

public abstract class Case {
	
	private TypeOfCase typeOfCase;
	private Provider provider;
	protected double price;
	protected int quantity;
	protected int MINIMUM_QUANTITY;
	
	public Case(){
		
	}
	
	public Case(TypeOfCase type,Provider provider, double price,int quantity, int minimum){
		this.MINIMUM_QUANTITY = minimum;
		this.typeOfCase = type;
		this.provider = provider;
		this.price = price;
		this.quantity = quantity;
	}
	
	public TypeOfCase getTypeOfCase() {
		return typeOfCase;
	}
	public void setTypeOfCase(TypeOfCase typeOfCase) {
		this.typeOfCase = typeOfCase;
	}
	public Provider getProvider() {
		return provider;
	}
	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getMINIMUM_QUANTITY() {
		return MINIMUM_QUANTITY;
	}
	public void setMINIMUM_QUANTITY(int mINIMUM_QUANTITY) {
		MINIMUM_QUANTITY = mINIMUM_QUANTITY;
	}
	
	public boolean hasLowStock() {
		return getQuantity() <= getMINIMUM_QUANTITY();
	}
	
	public void decreaseInventory() {
		this.quantity --;
	}
	
	
}
