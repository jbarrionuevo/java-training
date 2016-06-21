/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.day1.exercises.layersAndTier.IONSolidAplication.Service;

import edu.globant.day1.exercises.layersAndTier.IONSolidAplication.Dao.SalesDao;
import edu.globant.day1.exercises.layersAndTier.IONSolidAplication.Dao.SalesDaoImpl;
import edu.globant.day1.exercises.layersAndTier.IONSolidAplication.Entity.Sale;




/**
 *
 * @author federico.calarco
 */
public class SalesServiceImpl implements SalesService{

    SalesDao salesDao = new SalesDaoImpl();
    InventoryService inventoryService = new InventoryServiceImpl();

    @Override
    public void addSale(Sale sale) {
        
        
        salesDao.addSale(sale);
    }


    
}
