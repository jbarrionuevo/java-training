/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.day1.exercises.layersAndTier.IONSolidAplication.Entity;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author fedec
 */
public class Cart {
    
    Map<Case,Integer> cart = new HashMap<Case,Integer>();

    public Cart() {
    }

    public Map<Case, Integer> getCart() {
        return cart;
    }

    public void setCart(Map<Case, Integer> cart) {
        this.cart = cart;
    }
    
    public void addElementsToCart(Case caseCover, int cant) {
    
        cart.put(caseCover, cant);
    }
}
