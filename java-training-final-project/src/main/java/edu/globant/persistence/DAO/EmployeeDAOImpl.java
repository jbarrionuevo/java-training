package edu.globant.persistence.DAO;

import org.hibernate.Session;

import edu.globant.domain.BaseEntity;
import edu.globant.domain.Employee;

@SuppressWarnings("rawtypes")
public class EmployeeDAOImpl extends AbstractDAO<Employee> implements EmployeeDAO{
	
	public EmployeeDAOImpl(Session session) {
		super(session);
	}
}
