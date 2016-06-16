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
public class Receipt {
    
    private Customer customer;
    private String dateOfSale;
    private double price;
    private int cantUnits;
    private String store;  // name of the store where the sale took place. 

    public Receipt(Customer customer, String dateOfSale, double price, int cantUnits, String store) {
        this.customer = customer;
        this.dateOfSale = dateOfSale;
        this.price = price;
        this.cantUnits = cantUnits;
        this.store = store;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getDateOfSale() {
        return dateOfSale;
    }

    public void setDateOfSale(String dateOfSale) {
        this.dateOfSale = dateOfSale;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCantUnits() {
        return cantUnits;
    }

    public void setCantUnits(int cantUnits) {
        this.cantUnits = cantUnits;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    
}
