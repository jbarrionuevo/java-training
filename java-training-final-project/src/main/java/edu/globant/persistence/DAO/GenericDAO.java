package edu.globant.persistence.DAO;

import java.util.List;

import edu.globant.domain.BaseEntity;

public interface GenericDAO<T extends BaseEntity> {

	void save(T entity);
	T findById(Long id);
	void update(T entity);
	void delete(T entity);
	List<T> findAll();

}
