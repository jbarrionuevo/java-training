package edu.globant;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

import edu.globant.service.employee.CreateEmployeeService;
import edu.globant.domain.Employee;
import edu.globant.utils.MySQLDataSourceProvider;
import edu.globant.persistence.DAO.EmployeeDAO;
import edu.globant.persistence.DAO.hibernate.utils.HibernateUtils;

import java.util.Scanner;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
@EnableAutoConfiguration
// @ComponentScan
public class Application {
	private static CreateEmployeeService service;
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

			service = new CreateEmployeeService(sessionFactory.openSession());
			service.create(new Employee("Juan", "seller"));
		} catch (Exception e) {
			LOGGER.error("Something terrible happened.", e);
		}
	}
}
