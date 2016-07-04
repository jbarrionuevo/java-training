package edu.globant.service;

import java.util.List;

import edu.globant.domain.BaseEntity;

public interface Service<T, E extends BaseEntity> {
	public void save(E entity);

	public E findById(T id);

	public void update(E entity);

	public void delete(E entity);

	public List<E> findAll();

}
