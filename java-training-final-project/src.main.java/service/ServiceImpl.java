package service;

import java.util.List;

import org.hibernate.Session;

import domain.BaseEntity;
import persistence.DAO.AbstractDAO;
import persistence.DAO.DAOImpl;

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
