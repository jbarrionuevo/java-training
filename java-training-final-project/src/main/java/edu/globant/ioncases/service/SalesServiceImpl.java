/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.service;

import edu.globant.ioncases.dao.SalesDao;
import edu.globant.ioncases.dao.SalesDaoImpl;
import edu.globant.ioncases.entity.Sale;


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
