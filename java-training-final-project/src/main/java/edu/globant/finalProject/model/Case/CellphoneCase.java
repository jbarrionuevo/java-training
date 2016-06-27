package edu.globant.finalProject.model.Case;

import java.util.ArrayList;
import java.util.TreeSet;

import edu.globant.finalProject.model.Provider.Provider;

public class CellphoneCase extends Case{
	
	public CellphoneCase(int id, String name, TreeSet<Provider> providers,ArrayList<Device> devices, Design design, double price, int minimum){
		super(id, name, providers, devices, design, price, minimum);
	}
	
	
}
