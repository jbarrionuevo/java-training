package edu.globant.persistence.DAO;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.globant.domain.BaseEntity;

public abstract class AbstractDAO<E extends BaseEntity> {

	protected Session session;
	protected Class<E> entityClass;

	@SuppressWarnings("unchecked")
	public AbstractDAO(Session session) {
		this.session = session;
		Type type = getClass().getGenericSuperclass();
		while (!(type instanceof ParameterizedType) || ((ParameterizedType) type).getRawType() != AbstractDAO.class) {
			if (type instanceof ParameterizedType) {
				type = ((Class<?>) ((ParameterizedType) type).getRawType()).getGenericSuperclass();
			} else {
				type = ((Class<?>) type).getGenericSuperclass();
			}
		}
		entityClass = (Class<E>) ((ParameterizedType) type).getActualTypeArguments()[0];
	}

	public void save(E entity) {
		// TODO: use Spring transactions
		Transaction trans = session.beginTransaction();
		session.save(entity);
		trans.commit();
	}

	public E findById(Long id) {
		return session.find(entityClass, id);
	}

	public void update(E entity) {
		session.update(entity);
	}

	public void delete(E entity) {
		session.delete(entity);
	}

	public List<E> findAll() {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<E> criteria = builder.createQuery(entityClass);
		Root<E> root = criteria.from(entityClass);
		criteria.select(root);
		return session.createQuery(criteria).getResultList();
	}

	// TODO: check implementation of the following method
	// public final void evict(BaseEntity object) {
	// session.evict(object);
	// }

	// TODO: check implementation of the following method
	// public final T merge(T object) {
	// return entityClass.cast(session.merge(object));
	// }
}