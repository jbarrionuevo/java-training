package edu.globant.day4.jpa.exercices;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.globant.day1.oop.exercices.models.Inventory;

public class InventoryDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void insert(Inventory inventory) {
		entityManager.persist(inventory);
	}

	public List<Inventory> selectAll() {
		Query query = entityManager.createQuery("select i from Inventory i");
		List<Inventory> inventories = (List<Inventory>) query.getResultList();
		return inventories;
	}
	
	public Inventory update(Inventory transientInventory){
		return entityManager.merge(transientInventory);
	}
}
