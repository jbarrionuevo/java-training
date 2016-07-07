/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.providerrest.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author federico.calarco
 */
public class CaseProduct {
    private Long id;
    private String design;
    private List<Device> compatibleDevices = new ArrayList<>();
    private double price;

    public CaseProduct() {
    }

    public CaseProduct(Long id, String design, double price) {
        this.id = id;
        this.design = design;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public List<Device> getCompatibleDevices() {
        return compatibleDevices;
    }

    public void setCompatibleDevices(List<Device> compatibleDevices) {
        this.compatibleDevices = compatibleDevices;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
    
}
