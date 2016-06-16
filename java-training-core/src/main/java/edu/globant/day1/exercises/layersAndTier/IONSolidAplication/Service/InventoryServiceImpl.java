/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.day1.exercises.layersAndTier.IONSolidAplication.Service;

import edu.globant.day1.exercises.layersAndTier.IONSolidAplication.Dao.InventoryDao;
import edu.globant.day1.exercises.layersAndTier.IONSolidAplication.Dao.InventoryDaoImpl;
import edu.globant.day1.exercises.layersAndTier.IONSolidAplication.Entity.Case;

/**
 *
 * @author federico.calarco
 */
public class InventoryServiceImpl implements InverntoryService{

    InventoryDao inventoryDao = new InventoryDaoImpl();
    
    @Override
    public void addStock(Case cases, int cantUnits) {
        
        inventoryDao.addStock();
    }

    @Override
    public void removeStock(Case cases, int cantUnits) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    
}
