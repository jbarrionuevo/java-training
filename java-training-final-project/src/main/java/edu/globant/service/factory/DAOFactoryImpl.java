package edu.globant.service.factory;

import org.hibernate.Session;
import edu.globant.persistence.DAO.EmployeeDAO;
import edu.globant.persistence.DAO.EmployeeDAOImpl;

public class DAOFactoryImpl implements DAOFactory {

	private Session session;

	public DAOFactoryImpl(Session session) {
		this.session = session;
	}

	@Override
	public EmployeeDAO createEmployeeDao() {
		return new EmployeeDAOImpl(session);
	}
}
