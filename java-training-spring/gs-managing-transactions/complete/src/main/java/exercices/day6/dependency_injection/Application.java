package exercices.day6.dependency_injection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
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
import exercices.day6.dependency_injection.services.ProviderService;
import hello.BookingService;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@ImportResource("classpath:beans.xml")
public class Application {
	
private static final Logger log = LoggerFactory.getLogger(Application.class);

	@Bean
	JdbcTemplate jdbcTemplate(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		log.info("Creating tables");
		return jdbcTemplate;
	}

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		CaseDeviceService caseDeviceService = ctx.getBean(CaseDeviceService.class);
		CaseDesignService caseDesignService = ctx.getBean(CaseDesignService.class);
		CaseService caseService = ctx.getBean(CaseService.class);
		ProviderService providerService = ctx.getBean(ProviderService.class);
		
		CaseDesign design1 = new CaseDesign("design1");
		CaseDesign design2 = new CaseDesign("design2");
		CaseDevice device1 = new CaseDevice("device1");
		CaseDevice device2 = new CaseDevice("device2");
		Provider provider1 = new Provider("provider", "Some St.");
		Provider provider2 = new Provider("provider2", "Some St. 2");
		Case case1 = new Case(design1, device1, 150.0, provider1);
		Case case2 = new Case(design2, device2, 250.0, provider2);
		
		caseDesignService.saveCaseDesigns(design1,design2);
		caseDeviceService.saveCaseDevices(device1,device2);
		providerService.saveProviders(provider1,provider2);
		
		caseService.saveCases(case1,case2);
		Assert.assertEquals("Should retrieve 2 cases", 2,
				caseService.findAllCases().size());
		
		for (Case aCase: caseService.findAllCases()) {
			log.info("So far, Case [" + aCase + "] is persisted.");
		}
		
//		HashMap<Case,Integer> caseDesire = new HashMap<Case,Integer>();
//		caseDesire.put(case1, 10);
//		caseDesire.put(case2, 25);
//		HashMap<Case,Integer> caseDesire2 = new HashMap<Case,Integer>();
//		caseDesire2.put(case1, 7);
//		caseDesire2.put(case2, 1);
		
//		orderService.saveOrder(new Order(caseDesire,new Date()));
//		orderService.addOrders(new Order(caseDesire,new Date()), new Order(caseDesire2,new Date()));
		
	}
	
	
}
