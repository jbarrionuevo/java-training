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
 * @author federico.calarco
 */
public class OrderSale {

    private long id;
    private Map<Case, Integer> order = new HashMap<>();

    public OrderSale() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Map<Case, Integer> getOrder() {
        return order;
    }

    public void setOrder(Map<Case, Integer> order) {
        this.order = order;
    }

    public void addCaseToOrder(Case caseCover, int amount) {
        // TODO: add amount not negative,  etc...
        order.put(caseCover, amount);

    }

    
    
    

}
