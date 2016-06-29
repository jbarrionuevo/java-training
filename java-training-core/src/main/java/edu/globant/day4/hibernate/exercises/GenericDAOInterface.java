package edu.globant.day4.hibernate.exercises;

import java.io.Serializable;
import java.util.List;

public interface GenericDAOInterface<T, Id extends Serializable> {

	public void save(T entity);

	public void update(T entity);

	public T findById(Id id);

	public void delete(T entity);

	public List<T> findAll();

}
