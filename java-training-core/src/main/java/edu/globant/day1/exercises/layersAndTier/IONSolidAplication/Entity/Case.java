/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.day1.exercises.layersAndTier.IONSolidAplication.Entity;


import edu.globant.day1.exercises.DDD.IONSolidAplication.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fedec
 */
public class Case {
    
    List<Device>  compatibleDevices = new ArrayList();
    private String design;
    private Double price;

    public Case(String design) {
        this.design = design;
    }

    public List<Device> getCompatibleDevices() {
        return compatibleDevices;
    }

    public void setCompatibleDevices(List<Device> compatibleDevices) {
        this.compatibleDevices = compatibleDevices;
    }
    
    public void addCompatibleDevices(Device device){
        this.compatibleDevices.add(device);
    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    



    
}
