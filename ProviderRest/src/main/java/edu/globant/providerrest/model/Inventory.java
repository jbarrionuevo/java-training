/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.providerrest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author federico.calarco
 */
public class Inventory {
    @JsonIgnore
    private Long id;
    private List<CaseProduct> inventory = new ArrayList<>();

    public Inventory() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CaseProduct> getInventory() {
        return inventory;
    }

    public void setInventory(List<CaseProduct> inventory) {
        this.inventory = inventory;
    }
    
    public void addItemToInventory(CaseProduct caseProduct) {
        inventory.add(caseProduct);
        
    }
}
