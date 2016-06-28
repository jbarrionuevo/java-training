package ilan;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;

import ilan.models.CaseProduct;
import ilan.models.CaseWrapper;
import ilan.models.CaseDesign;
import ilan.models.CaseDevice;
import ilan.models.Inventory;
import ilan.models.Provider;
import ilan.services.CaseDesignService;
import ilan.services.CaseDeviceService;
import ilan.services.CaseProductService;
import ilan.services.CaseWrapperService;
import ilan.services.InventoryService;
import ilan.services.ProviderService;

import java.util.Collection;
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

	/** UNCOMMENT THIS THE FIRST TIME TO CREATE THE TABLES **/
//	@Bean
//	JdbcTemplate jdbcTemplate(DataSource dataSource) {
//		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//		log.info("Creating tables");
//		jdbcTemplate.execute("DROP TABLE IF EXISTS case_wrapper");
//		jdbcTemplate.execute("DROP TABLE IF EXISTS inventory");
//
//		jdbcTemplate.execute("create table INVENTORY(id int(11) NOT NULL AUTO_INCREMENT, PRIMARY KEY (id))");
//		jdbcTemplate.execute("create table CASE_WRAPPER(id int(11) NOT NULL AUTO_INCREMENT, "
//				+ "current_stock int(11) NOT NULL, minimum_stock int(11) NOT NULL,"
//				+ "my_case_id BIGINT NOT NULL, "
//				+ "inventory_id INT NOT NULL, "
//				+ "PRIMARY KEY (id),"
//				+ "FOREIGN KEY(my_case_id) REFERENCES case_product(id),"
//				+ "FOREIGN KEY(inventory_id) REFERENCES inventory(id))");
//		
//		jdbcTemplate.batchUpdate("INSERT INTO INVENTORY(id) VALUES (1)");
//		return jdbcTemplate;
//	}

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		CaseDeviceService caseDeviceService = ctx.getBean(CaseDeviceService.class);
		CaseDesignService caseDesignService = ctx.getBean(CaseDesignService.class);
		CaseProductService caseProductService = ctx.getBean(CaseProductService.class);
		ProviderService providerService = ctx.getBean(ProviderService.class);
		InventoryService inventoryService = ctx.getBean(InventoryService.class);
		CaseWrapperService caseWrapperService = ctx.getBean(CaseWrapperService.class);
		
		/** UNCOMMENT THIS THE FIRST TIME TO CREATE SOME CASES **/
//		CaseDesign design1 = new CaseDesign("design1");
//		CaseDesign design2 = new CaseDesign("design2");
//		CaseDevice device1 = new CaseDevice("device1");
//		CaseDevice device2 = new CaseDevice("device2");
//		Provider provider1 = new Provider("provider", "Some St.");
//		Provider provider2 = new Provider("provider2", "Some St. 2");
//		CaseProduct case1 = new CaseProduct(design1, device1, 150.0, provider1);
//		CaseProduct case2 = new CaseProduct(design2, device2, 250.0, provider2);
		
//		caseDesignService.saveCaseDesigns(design1,design2);
//		caseDeviceService.saveCaseDevices(device1,device2);
//		providerService.saveProviders(provider1,provider2);
//		
//		caseService.saveCases(case1,case2);
//
//		for (CaseProduct aCase: caseService.findAllCases()) {
//			log.info("So far, Case [" + aCase + "] is persisted.");
//		}
//		
//		inventoryService.incrementStock(case1, 100);
//		inventoryService.incrementStock(case2, 250);
//		inventoryService.incrementStock(case1, 450);
		
		/**THEN USE THIS TO UPDATE THE STOCK **/
		Collection<CaseProduct> cases = caseProductService.findAllCases();
		for(CaseProduct aCase: cases){
			inventoryService.incrementStock(aCase, 17);
		}
		
	}
	
	
}
