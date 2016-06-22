package exercices.day6.dependency_injection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import exercices.day6.dependency_injection.models.Case;
import exercices.day6.dependency_injection.models.CaseDesign;
import exercices.day6.dependency_injection.models.CaseDevice;
import exercices.day6.dependency_injection.models.Order;
import exercices.day6.dependency_injection.models.Provider;
import exercices.day6.dependency_injection.services.CaseDesignService;
import exercices.day6.dependency_injection.services.CaseDeviceService;
import exercices.day6.dependency_injection.services.CaseService;
import exercices.day6.dependency_injection.services.OrderService;
import hello.BookingService;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@EnableAutoConfiguration
public class Application {
	
private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	@Bean
	JdbcTemplate jdbcTemplate(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		log.info("Creating tables");
//		jdbcTemplate.execute("drop table CASE if exists");
//		jdbcTemplate.execute("create table CASE("
//				+ "...)");
		return jdbcTemplate;
	}

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		CaseDeviceService caseDeviceService = ctx.getBean(CaseDeviceService.class);
		CaseDesignService caseDesignService = ctx.getBean(CaseDesignService.class);
		CaseService caseService = ctx.getBean(CaseService.class);
		
//		OrderService orderService = ctx.getBean(OrderService.class);
//		
		Case case1 = new Case(new CaseDesign("test"), new CaseDevice("test"), 150.0, new Provider("provider", "Some St."));
		Case case2 = new Case(new CaseDesign("test2"), new CaseDevice("test2"), 250.0, new Provider("provider2", "Some St. 2"));
		
		caseService.saveCase(case1);
		caseService.saveCase(case2);
//		
//		HashMap<Case,Integer> caseDesire = new HashMap<Case,Integer>();
//		caseDesire.put(case1, 10);
//		caseDesire.put(case2, 25);
//		HashMap<Case,Integer> caseDesire2 = new HashMap<Case,Integer>();
//		caseDesire2.put(case1, 7);
//		caseDesire2.put(case2, 1);
//		
//		orderService.addOrders(new Order(caseDesire,new Date()), new Order(caseDesire2,new Date()));
//		Assert.assertEquals("Should retrieve 2 orders", 2,
//				orderService.findAllOrders().size());
//		
//		for (Order order: orderService.findAllOrders()) {
//			log.info("So far, " + order + " is persisted.");
//		}
	}
	
	
}
