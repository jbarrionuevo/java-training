/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.model;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author federico.calarco
 */
public class Case {

    private String design;
    private Set<Device> compatibleDevices = new HashSet<>();
    private double price;
    private Set<Provider> providers = new HashSet<>();

    public Case(String design, double price) {
        this.design = design;
        this.price = price;
    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public Set<Device> getCompatibleDevices() {
        return compatibleDevices;
    }

    public void setCompatibleDevices(Set<Device> compatibleDevices) {
        this.compatibleDevices = compatibleDevices;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<Provider> getProvider() {
        return providers;
    }

    public void setProvider(Set<Provider> provider) {
        this.providers = provider;
    }

    public void addCompatibleDevices(Device device) {
        compatibleDevices.add(device);
    }

    public void addProvider(Provider provider) {
        providers.add(provider);
    }

}
