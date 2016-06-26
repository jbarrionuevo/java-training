package transactions.excercices;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import dependencyInjection.excercices.Sale;
import dependencyInjection.excercices.SaleEmployee;

@SpringBootApplication
public class Application {

	private final static Logger log = LoggerFactory.getLogger(Application.class);

	/*
	 * Scripts for creating database tables.
	 * */
	String CREATE_SALES_SCRIPT = "CREATE TABLE sales("
			+ "saleId varchar(20) NOT NULL,"
			+ "saleState varchar(10) NOT NULL,"
			+ "employeeId int(11) NOT NULL, PRIMARY KEY(saleId))";

	String ALTER_SALES_TABLE_SCRIPT = "ALTER TABLE sales ADD CONSTRAINT"
			+ " sales_ibfk_1 FOREIGN KEY (employeeId) REFERENCES"
			+ " employees (employeeId)";

	String CREATE_EMPLOYEES_SCRIPT = "CREATE TABLE employees("
			+ "employeeId int(11) NOT NULL AUTO_INCREMENT,"
			+ "name varchar(20) NOT NULL, PRIMARY KEY (employeeId))";

	/*
	 * I'm creating the SaleDAO bean
	 * */
	@Bean
	SaleDAO SaleDAO() {
		return new SaleDAO();
	}
	
	/*
	 * SpringBootApplication annotation in order to create this bean will pass
	 * as an argument the dataSource bean for the h2 database
	 */
	@Bean
	JdbcTemplate jdbcTemplate(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		log.info("Creating tables");
		jdbcTemplate.execute("drop table sales if exists");
		jdbcTemplate.execute("drop table employees if exists");
		jdbcTemplate.execute(CREATE_EMPLOYEES_SCRIPT);
		jdbcTemplate.execute(CREATE_SALES_SCRIPT);
		jdbcTemplate.execute(ALTER_SALES_TABLE_SCRIPT);
		return jdbcTemplate;
	}

	public static void main(String args[]) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		SaleDAO saleDAO = ctx.getBean(SaleDAO.class);
		List<Sale> todaySales = new ArrayList<Sale>();
		List<Sale> retrievedSales = new ArrayList<Sale>();
		
		todaySales.add(new Sale("XCO90", new SaleEmployee("Pablo")));
		todaySales.add(new Sale("XCO91", new SaleEmployee("Guillermo")));
		todaySales.add(new Sale("XCO92", new SaleEmployee("Maria")));
		todaySales.add(new Sale("XCO93", new SaleEmployee("Maria")));
		todaySales.add(new Sale("XCO94", new SaleEmployee("Pablo")));
		todaySales.add(new Sale("XCO95", new SaleEmployee("Guillermo")));
		todaySales.add(new Sale("XCO96", new SaleEmployee("Pablo")));
		
		saleDAO.insertSale(todaySales);
		
		try {
			retrievedSales = saleDAO.findAllSales();
		}
		catch(RuntimeException e) {
			log.error(e.getMessage());
		}
		
		retrievedSales.stream().forEach(s -> System.out.println(s.toString()));

	}
}