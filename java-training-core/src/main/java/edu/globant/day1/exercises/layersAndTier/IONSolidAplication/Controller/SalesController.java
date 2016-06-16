/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.day1.exercises.layersAndTier.IONSolidAplication.Controller;

import edu.globant.day1.exercises.designPatterns.Entity.Sale;
import edu.globant.day1.exercises.oop.service.SalesService;
import edu.globant.day1.exercises.oop.service.SalesServiceImpl;

/**
 *
 * @author federico.calarco
 */
public class SalesController {
    
    
    
    public static void addSale(Sale sale){
        SalesService salesService = new SalesServiceImpl();
        salesService.addSale(sale);
        
    }
}
