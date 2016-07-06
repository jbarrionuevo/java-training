/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.dao;

import edu.globant.ioncases.model.CaseCover;
import edu.globant.ioncases.model.CaseInventory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fedec
 */
@Repository
@Transactional
public class InventoryDaoImpl extends  GenericDaoImpl<CaseInventory, Long> implements InventoryDao {

    @Override
    public void addCase(CaseCover caseCover, int quantity) {
//        super.add(entity);
        System.out.println("Add case");
    }




}
