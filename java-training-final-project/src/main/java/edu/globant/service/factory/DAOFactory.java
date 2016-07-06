package edu.globant.service.factory;

import edu.globant.persistence.DAO.EmployeeDAO;

public interface DAOFactory {

	public EmployeeDAO createEmployeeDao();
}
