/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.day1.exercises.designPatterns.simpleFactory;

import edu.globant.day1.exercises.designPatterns.Entity.DeliverySeller;
import edu.globant.day1.exercises.designPatterns.Entity.Seller;
import edu.globant.day1.exercises.designPatterns.Entity.StoreSeller;



/**
 *
 * @author fedec
 */
public final class SellerFactory {
    
    private SellerFactory(){}

    public static Seller getSeller(String seller) {
        switch (seller.toUpperCase()) {
            case "STORESELLER":
                return new StoreSeller();
            case "DELIVERYSELLER":
                return new DeliverySeller();
            default:
                return null;
        }
    }
}
