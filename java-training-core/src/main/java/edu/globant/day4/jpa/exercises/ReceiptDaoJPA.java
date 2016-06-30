package edu.globant.day4.jpa.exercises;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.globant.day1.ddd.exercises.model.Inventory;

public class ReceiptDaoJPA {

	@PersistenceContext
	private EntityManager em;

	public EntityManager getEntityManager() {
		return em;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.em = entityManager;
	}

	public void insert(Inventory inventory) {
		em.persist(inventory);
	}

	public List<Inventory> findAll() {
		return em.createQuery("from Inventory").getResultList();
	}

	public Inventory update(Inventory inventory) {
		return em.merge(inventory);
	}

}
