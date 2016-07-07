/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.providerrest.model;

/**
 *
 * @author federico.calarco
 */
public class Device {

    private Long id;
    private TypeDevice type;
    private String model;

    public Device() {
    }

    public Device(Long id, TypeDevice type, String model) {
        this.id = id;
        this.type = type;
        this.model = model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeDevice getType() {
        return type;
    }

    public void setType(TypeDevice type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    
    
    

}
