package edu.globant;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

import edu.globant.service.employee.CreateEmployeeServiceImpl;
import edu.globant.service.sales.CreateSalesServiceImpl;
import edu.globant.domain.Employee;
import edu.globant.domain.Sell;
import edu.globant.domain.Store;
import edu.globant.utils.MySQLDataSourceProvider;
import edu.globant.persistence.DAO.EmployeeDAO;
import edu.globant.persistence.DAO.EmployeeDAOImpl;
import edu.globant.persistence.DAO.SellDAO;
import edu.globant.persistence.DAO.SellDAOImpl;
import edu.globant.persistence.DAO.hibernate.utils.HibernateUtils;

import java.util.Scanner;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
@EnableAutoConfiguration
// @ComponentScan
public class Application {
	private static CreateEmployeeServiceImpl employeeService;
	private static CreateSalesServiceImpl serviceSell;
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
	private static final String configurationPath = "/edu/globant/config/database.properties";
	private static final String hibernateConfigXml = "/edu/globant/config/hibernate.cfg.xml";
	@SuppressWarnings("unused")
	private Scanner scanner;
	@SuppressWarnings("unused")
	private SessionFactory sessionFactory;

	public Application(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// SpringApplication.run(Application.class, args);

		MySQLDataSourceProvider dsProvider = new MySQLDataSourceProvider();

		try (SessionFactory sessionFactory = HibernateUtils.buildSessionFactory(hibernateConfigXml,
				dsProvider.getMySQLDataSource(configurationPath))) {
			Application application = new Application(sessionFactory);

			EmployeeDAO employeeDAO = new EmployeeDAOImpl(sessionFactory.openSession());
			employeeService = new CreateEmployeeServiceImpl(employeeDAO);
			
			employeeService.create(new Employee("Juan", "seller"));
			
			SellDAO sellDAO = new SellDAOImpl(sessionFactory.getCurrentSession());
			serviceSell = new CreateSalesServiceImpl(sellDAO);
			
			employeeService.create(new Employee("Juan", "seller"));
			
			Sell sell1 = new Sell(new Store("Local1", "Carapachay"), new Employee("Juan", "seller"));
			
			serviceSell.create(sell1);
		} catch (Exception e) {
			LOGGER.error("Something terrible happened.", e);
		}
	}
}
