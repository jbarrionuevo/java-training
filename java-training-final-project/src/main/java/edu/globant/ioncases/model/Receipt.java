/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.model;

/**
 *
 * @author federico.calarco
 */
public class Receipt {
    
    private long id;
    private Customer customer;
    private String dateOfSale;
    private double totalPrice;
    private Store store;

    public Receipt(Customer customer, String dateOfSale, double totalPrice, Store store) {
        this.customer = customer;
        this.dateOfSale = dateOfSale;
        this.totalPrice = totalPrice;
        this.store = store;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    @Override
    public String toString() {
        return "Receipt{" + "customer=" + customer + ", dateOfSale=" + dateOfSale + ", totalPrice=" + totalPrice + ", store=" + store + '}';
    }


    
    
}
