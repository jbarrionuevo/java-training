/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.controller;

import edu.globant.ioncases.model.Employee;
import edu.globant.ioncases.model.Store;
import edu.globant.ioncases.model.StoreSeller;

/**
 *
 * @author fedec
 */
public class Test {
    
    public static void main(String[] args) {
        
        Employee e = new StoreSeller("Fede", new Store("store"));
        
        System.out.println(e.getFullname());
    }
}
