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
public class Logistic extends Employee{
    
    private Inventory inventory;

    
    public Logistic(Inventory inventory, String fullname, String jobTitle) {
        super(fullname, jobTitle);
        this.inventory = inventory;
    }


    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    
    
    
}
