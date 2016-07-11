/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.model2;

import edu.globant.ioncases.model.Provider;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author federico.calarco
 */
public abstract class Product {

    private Long id;
    private double price;
    private int stock;
    private int min_stock; // Set minimum stock to alert logistic team
    private List<Provider> providers = new ArrayList<>();

    public Product() {
    }

    public Product(double price, int stock, int min_stock) {
        this.price = price;
        this.stock = stock;
        this.min_stock = min_stock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getMin_stock() {
        return min_stock;
    }

    public void setMin_stock(int min_stock) {
        this.min_stock = min_stock;
    }

    public List<Provider> getProviders() {
        return providers;
    }

    public void setProviders(List<Provider> providers) {
        this.providers = providers;
    }

}
