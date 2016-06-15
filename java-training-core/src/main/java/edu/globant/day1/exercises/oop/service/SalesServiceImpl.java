/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.day1.exercises.oop.service;

import edu.globant.day1.exercises.oop.dao.SalesDao;
import edu.globant.day1.exercises.oop.dao.SalesDaoImpl;


import edu.globant.day1.exercises.oop.entity.Sale;

/**
 *
 * @author fedec
 */
public class SalesServiceImpl implements SalesService{

    SalesDao salesDao = new SalesDaoImpl();
    
    @Override
    public void addSale(Sale sale) {

        salesDao.addSale(sale);
    }
    
    
    
}
