/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.day1.exercises.designPatterns.Entity;

import java.util.HashMap;

/**
 *
 * @author fedec
 */
public class Inventory {
    
    HashMap<Case,Integer> StockCases = new HashMap();

    public Inventory() {
    }

    public HashMap getStockCases() {
        return StockCases;
    }

    public void setStockCases(HashMap StockCases) {
        this.StockCases = StockCases;
    }
    
    
}
