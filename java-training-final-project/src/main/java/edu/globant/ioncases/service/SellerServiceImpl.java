/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.service;

import edu.globant.ioncases.entity.Cart;
import edu.globant.ioncases.entity.Customer;

/**
 *
 * @author fedec
 */
public class SellerServiceImpl implements SellerService{


   
    public void newSale(Customer customer, Cart cart) {
        
        // Check stock
        InventoryService inventoryService = new InventoryServiceImpl();
        
        cart.getCart().forEach((key,value)->{
            System.out.println("Key: " + key.getDesign() + "Value: " + value);
        });
        

    }

    @Override
    public void Seller(edu.globant.ioncases.entity.Seller seller) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
