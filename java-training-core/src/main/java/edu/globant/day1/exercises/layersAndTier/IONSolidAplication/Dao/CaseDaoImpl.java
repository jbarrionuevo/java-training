/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.day1.exercises.layersAndTier.IONSolidAplication.Dao;

import edu.globant.day1.exercises.layersAndTier.IONSolidAplication.Entity.Case;


/**
 *
 * @author fedec
 */
public class CaseDaoImpl implements CaseDao{

    @Override
    public void newCase(Case caseCover) {
        System.out.println("New case cover created");
    }
    
}
