/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.day1.exercises.layersAndTier.IONSolidAplication.Service;

import edu.globant.day1.exercises.layersAndTier.IONSolidAplication.Entity.Cart;
import edu.globant.day1.exercises.layersAndTier.IONSolidAplication.Entity.Customer;
import edu.globant.day1.exercises.layersAndTier.IONSolidAplication.Entity.Seller;


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
    public void Seller(Seller seller) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
