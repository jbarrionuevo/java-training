/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.dao;

import edu.globant.ioncases.entity.Case;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;



/**
 *
 * @author federico.calarco
 */
public class InventoryDaoImpl implements InventoryDao{
    
    private Map<Case,Integer> inventory = new HashMap<Case,Integer>();

    @Override
    public int getStockByCase(Case cases) {
        return inventory.get(cases);
    }

    @Override
    public void addStock(Case caseCover, int cant) {
        
        if(inventory.get(caseCover) != null){
            int oldStock = inventory.get(caseCover);
            inventory.replace(caseCover, oldStock+cant);
        }else{
            inventory.put(caseCover, cant);
        }
        System.out.println("addStock OK: " + caseCover.getDesign() + " Stock -> " + inventory.get(caseCover) );
    }

    @Override
    public void removeStock(Case caseCover, int cant) {
        int oldStock  = inventory.get(caseCover);
        inventory.put(caseCover, oldStock-cant);
        
    }

    @Override
    public Map<Case,Integer> getAllStock() {
        return inventory;
    }




    
}
