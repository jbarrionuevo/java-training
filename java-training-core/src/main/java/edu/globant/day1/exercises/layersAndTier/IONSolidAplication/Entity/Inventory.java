/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.day1.exercises.layersAndTier.IONSolidAplication.Entity;



/**
 *
 * @author fedec
 */
public class Inventory {
    
    private Case cases;
    private int cantUnits;

    public Inventory(Case cases, int cantUnits) {
        this.cases = cases;
        this.cantUnits = cantUnits;
    }

    public Case getCases() {
        return cases;
    }

    public void setCases(Case cases) {
        this.cases = cases;
    }

    public int getCantUnits() {
        return cantUnits;
    }

    public void setCantUnits(int cantUnits) {
        this.cantUnits = cantUnits;
    }
    
}
