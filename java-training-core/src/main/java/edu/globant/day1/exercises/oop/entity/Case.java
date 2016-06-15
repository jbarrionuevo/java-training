/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.day1.exercises.oop.entity;

/**
 *
 * @author fedec
 */
public abstract class Case {
    
    private String design;
    private String device;

    public Case(String design, String device) {
        this.design = design;
        this.device = device;
    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }



    
}
