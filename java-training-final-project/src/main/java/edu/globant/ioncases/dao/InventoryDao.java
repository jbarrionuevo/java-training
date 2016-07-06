/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.dao;

import edu.globant.ioncases.model.CaseCover;
import edu.globant.ioncases.model.CaseInventory;

/**
 *
 * @author fedec
 */
public interface InventoryDao extends GenericDao<CaseInventory, Long>{
    
    void addCase(CaseCover caseCover,int quantity);
}
