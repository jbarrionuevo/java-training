/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.model;

import java.util.Date;

/**
 *
 * @author federico.calarco
 */
public class Sale {
    
    private long id;
    private OrderSale orderSale;
    private Customer customer;
    private Seller seller;
    private SaleStatus status;
    private Receipt receipt;

    // TODO: change solution to add receipt

    public Sale(OrderSale orderSale, Customer customer, Seller seller, SaleStatus status, Receipt receipt) {
        this.orderSale = orderSale;
        this.customer = customer;
        this.seller = seller;
        this.status = status;
        this.receipt = receipt;
    }
    

    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public OrderSale getOrderSale() {
        return orderSale;
    }

    public void setOrderSale(OrderSale orderSale) {
        this.orderSale = orderSale;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public SaleStatus getStatus() {
        return status;
    }

    public void setStatus(SaleStatus status) {
        this.status = status;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }



    
    
}
