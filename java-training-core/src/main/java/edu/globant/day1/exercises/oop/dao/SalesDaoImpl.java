/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.day1.exercises.oop.dao;

import edu.globant.day1.exercises.oop.entity.Receipt;

/**
 *
 * @author fedec
 */
public class SalesDaoImpl implements SalesDao{

    @Override
    public void addSale(Receipt sale) {
        System.out.println("Add sale ");
    }
    
}
