package edu.globant.dayX.tema.exercises.day1.model;

import java.util.ArrayList;
import java.util.List;

public interface Sell {
	public float value = 0.0f;
	public List<Product> products = new ArrayList<Product>();
	
	//status possible values: draft, paid, cancelled or refund
	public String status = "";
	
	public void setValue(float value);
	public float getValue();
		
}
