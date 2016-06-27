package edu.globant.day1.exercises.ddd;

public enum DeviceTypeEnum {

	CELLPHONE("Cellphone"),
    TABLET("Tablet");
	
    private String deviceType;
     
    private DeviceTypeEnum(final String deviceType){
        this.deviceType = deviceType;
    }
     
    public String getDeviceType(){
        return this.deviceType;
    }
 
    @Override
    public String toString(){
        return this.deviceType;
    }
 
    public String getName(){
        return this.name();
    }
	
}