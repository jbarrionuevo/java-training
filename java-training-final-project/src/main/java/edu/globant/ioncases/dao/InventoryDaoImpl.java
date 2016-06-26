/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.dao;

import edu.globant.ioncases.model.Case;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fedec
 */
@Repository
public class InventoryDaoImpl implements InventoryDao{

    Map<Case,Integer> inventory = new HashMap<>();

    public InventoryDaoImpl() {
        
        Case c = new Case("Case batman", 20);
        c.setId(1);
        Case c2 = new Case("Case robin", 10);
        c2.setId(2);
        inventory.put(c, 10);
        inventory.put(c2, 4);
        
        
    }
    
    
    
    @Override
    public void addCase(Case caseCover, int quantity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<Case, Integer> getAll() {
        return inventory;
    }
    
}
