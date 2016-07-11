/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.model2;

import edu.globant.ioncases.model.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author federico.calarco
 */

public class Inventory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @ElementCollection
    private Map<CaseCover, Integer> inventoryMap = new HashMap<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Map<CaseCover, Integer> getInventory() {
        return inventoryMap;
    }

    public void setInventory(Map<CaseCover, Integer> inventory) {
        this.inventoryMap = inventory;
    }

}
