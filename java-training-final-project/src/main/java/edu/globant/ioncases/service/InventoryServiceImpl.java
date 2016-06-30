/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.service;

import edu.globant.ioncases.dao.InventoryDao;
import edu.globant.ioncases.model.CaseCover;
import edu.globant.ioncases.model.CaseInventory;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fedec
 */
@Service
public class InventoryServiceImpl implements InventoryService{

    @Autowired
    InventoryDao inventoryDao;
    
    @Override
    public void addCase(CaseCover caseCover, int quantity) {
       inventoryDao.addCase(caseCover, quantity);
    }

    @Override
    public List<CaseInventory> getAll() {
        return inventoryDao.getAll();
    }
    
    
}
