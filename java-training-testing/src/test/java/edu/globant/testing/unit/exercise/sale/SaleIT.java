package edu.globant.testing.unit.exercise.sale;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SaleIT {

	private Sale sale;
	private Customer customer;
	private List<ProductCase> products;
	private Employee employee;
	private SaleProductDetail detail;

	final static int MAX_PRODUCTS = 3;

	@Before
	public void setUp() {
		customer = new Customer(12561L, "Alejandro", "Diaz", 39, true, "Argentina");
		employee = new Employee(12561L, "Pablo", "Pellecchia", 27, true, "Av. Cordoba", EmployeeDepartment.SALES);
		products = new ArrayList<ProductCase>();
		products.add(new ProductCase(123456L, "iPhone6 Case", CaseDevice.iPhone6, CaseDesign.RealCase, 19.65, 15));
		products.add(new ProductCase(135798L, "Nexus Case", CaseDevice.iPhone6, CaseDesign.OMCase, 17.36, 15));
		products.add(new ProductCase(9764312L, "Nexus Case", CaseDevice.Nexus_6, CaseDesign.OMCase, 15.18, 15));
	}

	@Test
	public void processSale() throws SaleModificationException {
		Double expectedTotal = 0.0;
		
		sale = new Sale(123456L, employee, customer);

		for (ProductCase p : products) {
			sale.addProducts(p, 18);
		}
		
		sale.removeSaleDetail(products.get(1));
		products.remove(1);
		sale.setNewSaleState(SaleState.PAID);
		
		for (ProductCase p : products) {
			detail = sale.getSaleProductDetail(p);
			expectedTotal = detail.getTotalPrice() + expectedTotal;
			assertThat(detail.getProductCase().getCaseProductId(), equalTo(p.getCaseProductId()));
		}

		assertThat(expectedTotal, equalTo(sale.getSaleTotal()));		
	}
	
	@After
	public void tearDown() {
		customer = null;
		products = null;
		detail = null;
		employee = null;
		assertNull(products);
		assertNull(customer);
		assertNull(detail);
		assertNull(employee);
	}
}
