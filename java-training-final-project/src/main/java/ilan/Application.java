package ilan;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

import ilan.models.CaseProduct;
import ilan.models.CaseSeller;
import ilan.models.CaseWrapper;
import ilan.models.CaseDesign;
import ilan.models.CaseDevice;
import ilan.models.Inventory;
import ilan.models.Provider;
import ilan.models.StoreSeller;
import ilan.services.CaseDesignService;
import ilan.services.CaseDeviceService;
import ilan.services.CaseProductService;
import ilan.services.CaseSellerService;
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
@EnableScheduling
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

//		CaseDeviceService caseDeviceService = ctx.getBean(CaseDeviceService.class);
//		CaseDesignService caseDesignService = ctx.getBean(CaseDesignService.class);
//		CaseProductService caseProductService = ctx.getBean(CaseProductService.class);
//		ProviderService providerService = ctx.getBean(ProviderService.class);
//		InventoryService inventoryService = ctx.getBean(InventoryService.class);
//		CaseWrapperService caseWrapperService = ctx.getBean(CaseWrapperService.class);
//		CaseSellerService caseSellerService = ctx.getBean(CaseSellerService.class);
//		
//		/** UNCOMMENT THIS THE FIRST TIME TO CREATE SOME CASES **/
//		CaseDesign design1 = new CaseDesign("design1");
//		CaseDesign design2 = new CaseDesign("design2");
//		CaseDesign design3 = new CaseDesign("design3");
//		CaseDevice device1 = new CaseDevice("device1");
//		CaseDevice device2 = new CaseDevice("device2");
//		CaseDevice device3 = new CaseDevice("device3");
//		Provider provider1 = new Provider("provider", "Some St.");
//		Provider provider2 = new Provider("provider2", "Some St. 2");
//		Provider provider3 = new Provider("provider3", "Some St. 3");
//		
//		CaseProduct case1 = new CaseProduct(design1, device1, 150.0, provider1);
//		CaseProduct case2 = new CaseProduct(design1, device2, 250.0, provider2);
//		CaseProduct case3 = new CaseProduct(design1, device3, 350.0, provider3);
//		
//		CaseProduct case4 = new CaseProduct(design2, device1, 100.0, provider1);
//		CaseProduct case5 = new CaseProduct(design2, device2, 200.0, provider2);
//		CaseProduct case6 = new CaseProduct(design2, device3, 300.0, provider3);
//		
//		CaseProduct case7 = new CaseProduct(design3, device1, 170.0, provider1);
//		CaseProduct case8 = new CaseProduct(design3, device2, 240.0, provider2);
//		CaseProduct case9 = new CaseProduct(design3, device3, 310.0, provider3);
//
//		
//		caseDesignService.saveCaseDesigns(design1,design2,design3);
//		caseDeviceService.saveCaseDevices(device1,device2,device3);
//		providerService.saveProviders(provider1,provider2,provider3);
//		
//		caseProductService.saveCases(case1,case2,case3,case4,case5,case6,case7,case8,case9);
//
//		for (CaseProduct aCase: caseProductService.findAllCases()) {
//			log.info("So far, Case [" + aCase + "] is persisted.");
//		}
//		
//		inventoryService.incrementStock(case1, 20, 0);
//		inventoryService.incrementStock(case2, 30, 0);
//		inventoryService.incrementStock(case3, 300, 100);
//		inventoryService.incrementStock(case4, 170, 20);
//		inventoryService.incrementStock(case5, 210,30);
//		inventoryService.incrementStock(case6, 410,40);
//		inventoryService.incrementStock(case7, 70,100);
//		inventoryService.incrementStock(case8, 80,0);
//		inventoryService.incrementStock(case9, 160,180);
//		
//		caseSellerService.save(new StoreSeller("store seller 1","Store"));
		
		/**THEN USE THIS TO UPDATE THE STOCK **/
//		Collection<CaseProduct> cases = caseProductService.findAllCases();
//		for(CaseProduct aCase: cases){
//			inventoryService.incrementStock(aCase, 17);
//		}
		
	}
	
	
}
