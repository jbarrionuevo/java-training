package edu.globant.service.employee;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import edu.globant.domain.Employee;
import edu.globant.persistence.DAO.EmployeeDAO;
import edu.globant.persistence.DAO.GenericDAO;
import edu.globant.service.GenericServiceImpl;

public class ListEmployeeServiceImpl extends GenericServiceImpl<Long, Employee> implements ListEmployeeService {

	private EmployeeDAO employeeDAO;

	@Autowired
	JdbcTemplate jdbcTemplate;

	private final static Logger log = LoggerFactory.getLogger(ListEmployeeServiceImpl.class);

	public ListEmployeeServiceImpl(EmployeeDAO dao) {
		employeeDAO = dao;
	}

	public Employee findById(Long id) {
		Employee employee = (Employee) employeeDAO.findById(id);
		return employee;
	}

	@Override
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

	@Override
	public GenericDAO<Employee> getDao() {
		// TODO Auto-generated method stub
		return employeeDAO;
	}
}
