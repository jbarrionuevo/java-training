/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.dao;

import edu.globant.ioncases.entity.Sale;




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
