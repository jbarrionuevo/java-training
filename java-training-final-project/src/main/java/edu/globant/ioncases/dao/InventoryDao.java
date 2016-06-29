/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.dao;

import edu.globant.ioncases.model.CaseCover;
import edu.globant.ioncases.model.CaseInventory;
import java.util.List;
import java.util.Map;

/**
 *
 * @author fedec
 */
public interface InventoryDao {
    
    void addCase(CaseCover caseCover,int quantity);
    List<CaseInventory> getAll();
}
