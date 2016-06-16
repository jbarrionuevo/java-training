/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.day1.exercises.layersAndTier.IONSolidAplication.Dao;

import edu.globant.day1.exercises.layersAndTier.IONSolidAplication.Entity.Sale;



/**
 *
 * @author federico.calarco
 */
public class SalesDaoImpl implements SalesDao{

    @Override
    public void addSale(Sale sale) {
        System.out.println("Sale saved");
    }
    
}
