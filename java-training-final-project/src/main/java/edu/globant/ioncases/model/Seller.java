/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.model;




/**
 *
 * @author fedec
 */
public abstract class Seller extends Employee{

    private Store store;

    public Seller(Store store, String fullname, String jobTitle) {
        super(fullname, jobTitle);
        this.store = store;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
    

    
    
    
}
