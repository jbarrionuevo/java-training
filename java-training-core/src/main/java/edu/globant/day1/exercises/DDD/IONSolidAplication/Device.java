/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.day1.exercises.DDD.IONSolidAplication;



/**
 *
 * @author federico.calarco
 */
public class Device {
    
    private DeviceType deviceType; // CELLPHONE or TABLET
    private String model;

    public Device(DeviceType deviceType, String model) {
        this.deviceType = deviceType;
        this.model = model;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    
    
}
