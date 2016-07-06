package edu.globant.service;

import java.util.List;

import edu.globant.domain.BaseEntity;
import edu.globant.persistence.DAO.AbstractDAO;

public abstract class GenericServiceImpl<T, E extends BaseEntity> implements Service<T, E> {

	private AbstractDAO<BaseEntity> dao;

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
