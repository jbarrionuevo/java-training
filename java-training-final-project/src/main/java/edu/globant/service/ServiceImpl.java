package edu.globant.service;

import java.util.List;

import org.hibernate.Session;

import edu.globant.domain.BaseEntity;
import edu.globant.persistence.DAO.AbstractDAO;
import edu.globant.persistence.DAO.DAOImpl;

public abstract class ServiceImpl<T, E extends BaseEntity> implements Service<T, E> {

	private AbstractDAO<BaseEntity> dao;

	public ServiceImpl(Session session) {
		dao = new DAOImpl<E>(session);
	}

	public void save(E entity) {
		dao.save(entity);
	}

	public E findById(T id) {
		return null;
	}

	public void update(E entity) {

	}

	public void delete(E entity) {

	}

	public List<E> findAll() {
		return null;
	}
}
