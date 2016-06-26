/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.service;

import edu.globant.ioncases.dao.InventoryDao;
import edu.globant.ioncases.model.Case;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fedec
 */
@Service
public class InventoryServiceImpl implements InventoryService{

    @Autowired
    InventoryDao inventoryDao;
    
    @Override
    public void addCase(Case caseCover, int quantity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<Case, Integer> getAll() {
        return inventoryDao.getAll();
    }
    
    
}
