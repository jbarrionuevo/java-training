/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.entity;

/**
 *
 * @author fedec
 */
public class Sale {
    private Case deviceCase;
    private Receipt receipt;
    private SaleStatus status;

    public Sale(Case deviceCase, Receipt receipt, SaleStatus status) {
        this.deviceCase = deviceCase;
        this.receipt = receipt;
        this.status = status;
    }

    public Case getCases() {
        return deviceCase;
    }

    public void setCases(Case deviceCase) {
        this.deviceCase = deviceCase;
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
