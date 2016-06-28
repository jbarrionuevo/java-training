package edu.globant.day4.hibernate.exercices;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import edu.globant.day1.oop.exercices.models.Inventory;

public class InventoryDao implements GenericDaoInterface<Inventory, Long> {

	private Session currentSession;
	private Transaction currentTransaction;

	public InventoryDao() {
	}

	public Session openCurrentSession() {
		currentSession = getSessionFactory().openSession();
		return currentSession;
	}

	public Session openCurrentSessionwithTransaction() {
		currentSession = getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}

	public void closeCurrentSession() {
		currentSession.close();
	}

	public void closeCurrentSessionwithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}

	private static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}

	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}

	public void persist(Inventory entity) {
		getCurrentSession().save(entity);
	}

	public void update(Inventory entity) {
		getCurrentSession().update(entity);
	}

	public Inventory findById(Long id) {
		Inventory inventory = (Inventory) getCurrentSession().get(Inventory.class, id);
		return inventory;
	}

	public void delete(Inventory entity) {
		getCurrentSession().delete(entity);
	}

	@SuppressWarnings("unchecked")

	public List<Inventory> findAll() {
		List<Inventory> inventories = (List<Inventory>) getCurrentSession().createQuery("from Inventory").list();
		return inventories;
	}

	public void deleteAll() {
	        List<Inventory> entityList = findAll();
	        for (Inventory entity : entityList) {
	            delete(entity);
	        }
	 }
}
