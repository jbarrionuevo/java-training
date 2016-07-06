/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.dao;

import edu.globant.ioncases.model.CaseCover;
import edu.globant.ioncases.model.CaseInventory;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
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

    @Override
    public void addCase(CaseCover caseCover, int quantity) {
        CaseInventory ci = new CaseInventory(caseCover,quantity);
        getCurrentSession().saveOrUpdate(ci);
    }

    @Override
    public List<CaseInventory> getAll() {
        return getCurrentSession().createCriteria(CaseInventory.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }


}
