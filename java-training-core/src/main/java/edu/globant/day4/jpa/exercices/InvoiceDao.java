package edu.globant.day4.jpa.exercices;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.globant.day1.oop.exercices.models.Receipt;

public class InvoiceDao {

	@PersistenceContext
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void insert(Receipt receipt) {
		entityManager.persist(receipt);
	}

	public List<Receipt> selectAll() {
		Query query = entityManager.createQuery("select r from Receipt r");
		List<Receipt> receipts = (List<Receipt>) query.getResultList();
		return receipts;
	}

	public Receipt update(Receipt transientReceipt) {
		return entityManager.merge(transientReceipt);
	}
}
