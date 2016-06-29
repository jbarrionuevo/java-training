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
public class SaleDetail {
    private long id;
    private CaseCover caseCover;
    private int quantity;

    public SaleDetail(CaseCover caseCover, int quantity) {
        this.caseCover = caseCover;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CaseCover getCaseCover() {
        return caseCover;
    }

    public void setCaseCover(CaseCover caseCover) {
        this.caseCover = caseCover;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
    
    
    
}
