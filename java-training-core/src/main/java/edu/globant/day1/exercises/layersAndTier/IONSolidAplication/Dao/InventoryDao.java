/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.day1.exercises.layersAndTier.IONSolidAplication.Dao;


import edu.globant.day1.exercises.layersAndTier.IONSolidAplication.Entity.Case;
import java.util.Map;

/**
 *
 * @author federico.calarco
 */
public interface InventoryDao {

    int getStockByCase(Case cases);
    
    Map<Case,Integer> getAllStock();

    void addStock(Case caseCover, int cant);

    void removeStock(Case caseCover, int cant);

}
