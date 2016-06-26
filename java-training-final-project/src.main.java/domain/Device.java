package domain;

import org.apache.commons.lang3.Validate;



public class Device {
	public enum TYPE {CELL, TABLET};
	
	public Device(TYPE type){
		Validate.isTrue(type.equals(TYPE.CELL) || type.equals(TYPE.TABLET));
	}
}
