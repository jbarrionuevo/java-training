package edu.globant.testing;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.globant.domain.Employee;
import edu.globant.domain.Sell;
import edu.globant.domain.Store;
import edu.globant.persistence.DAO.EmployeeDAO;
import edu.globant.persistence.DAO.EmployeeDAOImpl;
import edu.globant.persistence.DAO.SellDAO;
import edu.globant.persistence.DAO.SellDAOImpl;
import edu.globant.persistence.DAO.hibernate.utils.HibernateUtils;
import edu.globant.service.employee.CreateEmployeeServiceImpl;
import edu.globant.service.employee.ListEmployeeServiceImpl;
import edu.globant.service.sales.CreateSalesServiceImpl;
import edu.globant.service.sales.ListSalesServiceImpl;
import edu.globant.utils.MySQLDataSourceProvider;

public class SellServiceIT {

	private static final String configurationPath = "/edu/globant/config/database.properties";
	private static final String hibernateConfigXml = "/edu/globant/config/hibernate.cfg.xml";
	private CreateSalesServiceImpl createSalesService;
	private ListSalesServiceImpl listSalesService;
	MySQLDataSourceProvider dsProvider = new MySQLDataSourceProvider();
	SellDAO sellDAO;
	ApplicationContext context;
	Session session;
	Employee seller1;
	Employee seller2;
	Sell sell;
	Store store;

	@Before
	public void setUp() {

		SessionFactory sessionFactory = HibernateUtils.buildSessionFactory(hibernateConfigXml,
				dsProvider.getMySQLDataSource(configurationPath));
		context = new ClassPathXmlApplicationContext("META-INF/beans.xml");
		session = sessionFactory.openSession();
		sellDAO = new SellDAOImpl(sessionFactory.openSession());
		createSalesService = new CreateSalesServiceImpl(sellDAO);
		seller1 = new Employee("Juan", "seller");
		seller2 = new Employee("Ramon", "Logistics");
		store = new Store("South Carolina", "1233 johan st.");
		sell = new Sell(store, seller1);
	}

	@Test
	public void createAndList() {
		createSalesService.create(sell);

//		Sell sell1DB = listSalesService.findById(seller1.getId());
//		Sell sell2DB = listSalesService.findById(seller2.getId());
//
//		assertThat(sell1DB, equalTo(seller1));
//		assertThat(sell1DB, not(equalTo(seller2)));
//		assertThat(seller2, equalTo(sell2DB));
//		assertThat(sell1DB, not(equalTo(sell2DB)));
	}

}
