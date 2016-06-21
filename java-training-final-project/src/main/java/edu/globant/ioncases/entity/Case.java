/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.entity;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author fedec
 */
public class Case {

    private int id;
    Set<Device> compatibleDevices = new HashSet<Device>();
    private String design;
    private double price;

    public Case() {
    }

    public Case(String design, double price) {
        this.design = design;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Device> getCompatibleDevices() {
        return compatibleDevices;
    }

    public void setCompatibleDevices(Set<Device> compatibleDevices) {
        this.compatibleDevices = compatibleDevices;
    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void addCompatibleDevice(Device device){
        this.compatibleDevices.add(device);
    }
    
}
