/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.service;

import edu.globant.ioncases.entity.Case;
import java.util.Map;


/**
 *
 * @author federico.calarco
 */
public interface InventoryService {
    
    int getStock(Case caseCover);
    Map<Case,Integer> getAllStock();
    void addStock(Case cases, int cantUnits);
    void removeStock(Case cases, int cantUnits);
}
