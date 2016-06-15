/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.day1.exercises.DDD.IONSolidAplication;



/**
 *
 * @author fedec
 */
public class Sale {
    private Receipt receipt;
    private SaleStatus status;

    public Sale(Receipt receipt, SaleStatus status) {
        this.receipt = receipt;
        this.status = status;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public SaleStatus getStatus() {
        return status;
    }

    public void setStatus(SaleStatus status) {
        this.status = status;
    }

    
    
    
    
}
