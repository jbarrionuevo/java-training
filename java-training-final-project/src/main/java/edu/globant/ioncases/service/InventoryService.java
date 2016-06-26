/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.service;

import edu.globant.ioncases.model.Case;
import java.util.Map;

/**
 *
 * @author fedec
 */
public interface InventoryService {
    
    void addCase(Case caseCover, int quantity);
    Map<Case,Integer> getAll();
    
}
