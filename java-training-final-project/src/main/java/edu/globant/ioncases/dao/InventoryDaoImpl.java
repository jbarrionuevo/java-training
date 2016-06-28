/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.dao;

import edu.globant.ioncases.model.Case;
import edu.globant.ioncases.model.CaseInventory;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fedec
 */
@Repository
@Transactional
public class InventoryDaoImpl implements InventoryDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

//    Map<Case, Integer> inventory = new HashMap<>();
    public InventoryDaoImpl() {

//        Case c = new Case("Case batman", 20);
//        c.setId(1);
//        Case c2 = new Case("Case robin", 10);
//        c2.setId(2);
//        inventory.put(c, 10);
//        inventory.put(c2, 4);
    }

    @Override
    public void addCase(Case caseCover, int quantity) {
        getCurrentSession().save(new CaseInventory(caseCover, quantity));
    }

    @Override
    public Map<Case, Integer> getAll() {

        return null;
    }

}
