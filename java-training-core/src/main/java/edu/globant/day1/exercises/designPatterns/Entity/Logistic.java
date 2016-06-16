/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.day1.exercises.designPatterns.Entity;

/**
 *
 * @author fedec
 */
public class Logistic extends Employee{
    
    private Inventory inventory;

    public Logistic(Inventory inventory, String name) {
        super(name);
        this.inventory = inventory;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    
    
    
}
