/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author fedec
 */
public class OrderSale2 {

    private long id;
    private Map<CaseCover, Integer> order = new HashMap<>();
    private Customer customer;
    private Seller seller;

    public OrderSale2() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Map<CaseCover, Integer> getOrder() {
        return order;
    }

    public void setOrder(Map<CaseCover, Integer> order) {
        this.order = order;
    }

    public void addCaseToOrder(CaseCover caseCover, int amount) {
        // TODO: add amount not negative,  etc...
        order.put(caseCover, amount);

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
    
    
}