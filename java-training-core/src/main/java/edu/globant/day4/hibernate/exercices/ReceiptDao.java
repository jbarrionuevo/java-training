package edu.globant.day4.hibernate.exercices;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import edu.globant.day1.oop.exercices.models.Receipt;

public class ReceiptDao implements GenericDaoInterface<Receipt,Long>{

	private Session currentSession;
	private Transaction currentTransaction;
	
	public ReceiptDao() {}
	
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
	
	@Override
	public void persist(Receipt entity) {
		getCurrentSession().save(entity);
	}

	@Override
	public void update(Receipt entity) {
		getCurrentSession().update(entity);
	}

	@Override
	public Receipt findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Receipt entity) {
		getCurrentSession().delete(entity);
	}

	@Override
	public List<Receipt> findAll() {
		List<Receipt> receipts = (List<Receipt>) getCurrentSession().createQuery("from Receipt").list();
		return receipts;
	}

	@Override
	public void deleteAll() {
		List<Receipt> entityList = findAll();
        for (Receipt entity : entityList) {
            delete(entity);
        }
	}
	
}
