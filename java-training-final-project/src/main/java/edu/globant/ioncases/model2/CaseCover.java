/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.model2;

import edu.globant.ioncases.model.Device;
import edu.globant.ioncases.model.Provider;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author federico.calarco
 */
public class CaseCover {
    private Long id;
    private List<Device> compatibleDevices = new ArrayList<>();
    private double price;
    private int stock;
    private Provider provider;

    public CaseCover() {
    }

    public CaseCover(double price, int stock, Provider provider) {
        this.price = price;
        this.stock = stock;
        this.provider = provider;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }
    
    
    
    
}
