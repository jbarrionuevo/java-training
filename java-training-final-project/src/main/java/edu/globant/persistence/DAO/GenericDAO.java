package edu.globant.persistence.DAO;

import java.util.List;

import edu.globant.domain.BaseEntity;

public interface GenericDAO<E extends BaseEntity> {

	void save(E entity);
	E findById(Long id);
	void update(E entity);
	void delete(E entity);
	List<E> findAll();

}
