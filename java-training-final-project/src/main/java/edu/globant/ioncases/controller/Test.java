/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.controller;

import edu.globant.ioncases.dao.CaseDao;
import edu.globant.ioncases.dao.CaseDaoImpl;
import edu.globant.ioncases.dao.InventoryDao;
import edu.globant.ioncases.dao.InventoryDaoImpl;
import edu.globant.ioncases.model.CaseCover;
import edu.globant.ioncases.model.CaseProduct;
import edu.globant.ioncases.model.Employee;
import edu.globant.ioncases.model.Product;
import edu.globant.ioncases.model.Store;
import edu.globant.ioncases.model.StoreSeller;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fedec
 */
public class Test {

    public static void main(String[] args) {

//        Employee e = new StoreSeller("Fede", new Store("store")); d
//        
        CaseCover c = new CaseCover("desiggnnn", 20000);
//        
//        InventoryDao inv = new InventoryDaoImpl();
//        
//        inv.addCase(c, 919);
//        
//        CaseDao caseDao = new CaseDaoImpl();
//        
//        caseDao.addCase(c);
//        

        List<Product> inventory = new ArrayList<>();
        
        
        
        Product p = new CaseProduct(20, 10, null, "Batman case");
       
        inventory.add(p);
        
        CaseProduct cp = (CaseProduct) inventory.get(0);
        System.out.println("-> " + cp.getDesign());
        
        System.out.println("ok");
    }
}
