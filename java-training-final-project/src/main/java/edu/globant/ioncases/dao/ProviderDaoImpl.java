/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.dao;

import edu.globant.ioncases.model.CaseCover;
import edu.globant.ioncases.model.Provider;
import java.util.List;
import org.hibernate.Criteria;
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
public class ProviderDaoImpl implements ProviderDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Provider getById(Long id) {
        return (Provider) getCurrentSession().get(Provider.class, id);
    }

    @Override
    public void addProvider(Provider provider) {
        getCurrentSession().save(provider);
    }

    @Override
    public List<Provider> getAll() {
        return getCurrentSession().createCriteria(Provider.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    @Override
    public List<CaseCover> casesAvailablesByProviderId() {
//        return getCurrentSession().createQuery
//        ("SELECT FROM edu.globant.ioncases.model.Provider.cases").list()g;

// ("SELECT c.cases FROM edu.globant.ioncases.model.Provider WHERE c.id=" + providerId)
        return null;
    }

}
