/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.day1.exercises.designPatterns.simpleFactory;

import edu.globant.day1.exercises.designPatterns.Entity.Employee;


/**
 *
 * @author fedec
 */
public class Main {
    
    public static void main(String ... args){
        
        // Build a Store Seller...
        
        Employee storeSeller = SellerFactory.getSeller("STORESELLER");
        
        System.out.println(storeSeller.getJobTitle());
        
        
    }
}
