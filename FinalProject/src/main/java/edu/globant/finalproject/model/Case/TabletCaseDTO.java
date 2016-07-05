package edu.globant.finalproject.model.Case;

import java.util.ArrayList;
import java.util.TreeSet;

public class TabletCaseDTO extends CaseDTO{

	public TabletCaseDTO(String name,String code, ArrayList<DeviceDTO> devices, DesignDTO design, double price) {
		super(name,code, devices, design, price);
	}
	
}
