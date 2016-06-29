package persistence.DAO;

import org.hibernate.Session;

@SuppressWarnings("rawtypes")
public class EmployeeDAO<Employee> extends AbstractDAO{
	
	public EmployeeDAO(Session session) {
		super(session);
	}
}
