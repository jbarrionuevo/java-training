package edu.globant.day4.hibernate.exercises;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import edu.globant.day1.ddd.exercises.model.Inventory;

public class InventoryDaoHibernate implements GenericDAOInterface<Inventory, Long> {

	private Session currentSession;
	private Transaction currentTransaction;

	public InventoryDaoHibernate() {
	}

	private static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
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

	@Override
	public void save(Inventory entity) {
		getCurrentSession().save(entity);
	}

	@Override
	public void update(Inventory entity) {
		getCurrentSession().update(entity);
	}

	@Override
	public Inventory findById(Long id) {
		Inventory rec = (Inventory) getCurrentSession().get(Inventory.class, id);
		return rec;
	}

	@Override
	public void delete(Inventory entity) {
		getCurrentSession().delete(entity);
	}

	@Override
	public List<Inventory> findAll() {
		List<Inventory> recs = (List<Inventory>) getCurrentSession().createQuery("from Inventory").list();
		return recs;
	}

}

