/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.service;

import edu.globant.ioncases.dao.InventoryDao;
import edu.globant.ioncases.dao.InventoryDaoImpl;
import edu.globant.ioncases.entity.Case;
import java.util.Map;


/**
 *
 * @author federico.calarco
 */
public class InventoryServiceImpl implements InventoryService{

    InventoryDao inventoryDao = new InventoryDaoImpl();
    
    @Override
    public void addStock(Case cases, int cantUnits) {
        
        inventoryDao.addStock(cases, cantUnits);
    }

    @Override
    public void removeStock(Case cases, int cantUnits) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getStock(Case caseCover) {
        return inventoryDao.getStockByCase(caseCover);
    }

    @Override
    public Map<Case,Integer> getAllStock() {
        return inventoryDao.getAllStock();
    }



    
}
