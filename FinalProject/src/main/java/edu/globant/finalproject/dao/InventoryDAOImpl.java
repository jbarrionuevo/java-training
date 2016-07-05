package edu.globant.finalproject.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.globant.finalproject.hibernate.Case;
import edu.globant.finalproject.hibernate.CaseStock;


@Repository
@Transactional
public class InventoryDAOImpl implements InventoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

	@Override
	public void add(Case c) {
		getCurrentSession().save(c);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CaseStock> getAll() {
			return  getCurrentSession()
					.createCriteria(CaseStock.class)
					.list();
	}
}
