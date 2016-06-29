/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.dao;

import edu.globant.ioncases.model.CaseCover;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author federico.calarco
 */
@Repository
@Transactional
public class CaseDaoImpl implements CaseDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addCase(CaseCover caseCover) {
        System.out.println("-> " + getCurrentSession().toString());
        System.out.println("---------------> add CASE: " + caseCover.getDesign());
        getCurrentSession().save(caseCover);
    }

    @Override
    public CaseCover getCaseById(long id) {
        return (CaseCover) getCurrentSession().get(CaseCover.class, id);
    }

    @Override
    public List<CaseCover> getAllCase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
