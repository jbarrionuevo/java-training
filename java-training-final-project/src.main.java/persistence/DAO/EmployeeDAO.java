package persistence.DAO;

import org.hibernate.Session;

import domain.Employee;

@SuppressWarnings("rawtypes")
public class EmployeeDAO extends AbstractDAO<Employee>{
	
	public EmployeeDAO(Session session) {
		super(session);
	}
}
