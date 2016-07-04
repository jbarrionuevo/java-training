package edu.globant.persistence.DAO;

import org.hibernate.Session;

import edu.globant.domain.Employee;

@SuppressWarnings("rawtypes")
public class EmployeeDAO extends AbstractDAO<Employee>{
	
	public EmployeeDAO(Session session) {
		super(session);
	}
}
