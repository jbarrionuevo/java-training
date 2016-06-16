package edu.globant.day1.designpatterns.excercises;

public class Configuration {

	//True online, false offline
	private boolean mode;
	private String userName;
	
	public Configuration(String userName, boolean mode){
		//Set the configuration
	}

	public boolean getMode() {
		return mode;
	}

	public String getUserName() {
		return userName;
	}
}
