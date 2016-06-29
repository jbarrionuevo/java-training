/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.model;

import javax.persistence.Entity;

/**
 *
 * @author federico.calarco
 */
@Entity
public class Cellphone extends Device {
    
    public Cellphone(String model) {
        super(model);
    }

    private Cellphone() {
        super("undefined");
    }

}
