package edu.globant.testing.unit.exercise.sale;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SaleTest {

	private ProductCase product, productTwo;
	private SaleProductDetail detail;
	private Employee employee;
	private Sale newSale;
	private Customer customer;

	@Before
	public void setUp() throws Exception {
		customer = new Customer(12561L, "Alejandro", "Diaz", 39, true, "Argentina");
		product = new ProductCase(123456L, "iPhone6 Case", CaseDevice.iPhone6, CaseDesign.RealCase, 19.65, 15);
		productTwo = new ProductCase(1234567L, "Nexus Case", CaseDevice.Nexus_6, CaseDesign.OMCase, 5.36, 15);
		detail = new SaleProductDetail(product, 18);
		employee = new Employee(12561L, "Pablo", "Pellecchia", 27, true, "Av. Cordoba", EmployeeDepartment.SALES);
	}

	@Test()
	public void createObjectWithValidArguments() {
		newSale = new Sale(45678L, employee, customer);
		assertThat("Wrong name returned", newSale.getEmployee().getName(), equalTo("Pablo"));
	}

	@Test(expected = NullPointerException.class)
	public void createWithNullSaleEmployeeArgument() {
		newSale = new Sale(45678L, null, customer);
	}

	@Test(expected = NullPointerException.class)
	public void createWithNullSaleCustomerArgument() {
		newSale = new Sale(45678L, employee, null);
	}

	@Test()
	public void changeSaleState() {
		newSale = new Sale(45678L, employee, customer);
		newSale.setNewSaleState(SaleState.CANCELLED);
		assertThat("The sale doesn't change it's state", SaleState.CANCELLED, equalTo(newSale.getSaleState()));
	}

	@Test()
	public void addProductsSaleWithNoException() {
		Double totalPrice;
		newSale = new Sale(45678L, employee, customer);
		try {
			newSale.addProducts(product, 18);
			newSale.addProducts(productTwo, 18);
			// totalPrice = (19.65 * 18) + (5.36 * 18) = 453.18
			totalPrice = (product.getUnitPrice() * 18) + (productTwo.getUnitPrice() * 18);
			newSale.setNewSaleState(SaleState.PAID);
			assertThat(totalPrice, equalTo(newSale.getSaleTotal()));
		} catch (SaleModificationException e) {

		}
	}

	@Test()
	public void addProductsWithNotDraftStateSale() {
		newSale = new Sale(45678L, employee, customer);
		newSale.setNewSaleState(SaleState.CANCELLED);
		// This sale can't be modified
		try {
			newSale.addProducts(product, 18);
			newSale.addProducts(productTwo, 18);
		} catch (SaleModificationException e) {
			assertThat(e.getClass(), equalTo(SaleModificationException.class));
		}
	}

	@Test()
	public void removeProductsWithDraftStateSale() {
		Double totalPrice;
		newSale = new Sale(45678L, employee, customer);
		// This sale can't be modified
		try {
			newSale.addProducts(product, 18);
			newSale.addProducts(productTwo, 18);
			newSale.removeSaleDetail(productTwo);
			totalPrice = product.getUnitPrice() * 18;
			assertThat(totalPrice, equalTo(newSale.getSaleTotal()));
		} catch (SaleModificationException e) {

		}
	}

	@Test()
	public void removeProductsWithNotDraftStateSale() {
		newSale = new Sale(45678L, employee, customer);
		// This sale can't be modified
		try {
			newSale.addProducts(product, 18);
			newSale.addProducts(productTwo, 18);
			newSale.setNewSaleState(SaleState.PAID);
			newSale.removeSaleDetail(productTwo);
		} catch (SaleModificationException e) {
			assertThat(e.getClass(), equalTo(SaleModificationException.class));
		}
	}

	@Test()
	public void getNotAddedSaleDetail() {
		newSale = new Sale(45678L, employee, customer);
		ProductCase productThree = new ProductCase(987654L, "iPhone6 Case", CaseDevice.iPhone6, CaseDesign.RealCase,
				19.65, 15);
		SaleProductDetail detail;
		// This sale can't be modified
		try {
			newSale.addProducts(product, 18);
			newSale.addProducts(productTwo, 18);
			detail = newSale.getSaleProductDetail(productThree);
			assertNull(detail);
		} catch (SaleModificationException e) {
			assertThat(e.getClass(), equalTo(SaleModificationException.class));
		}
	}

	@Test()
	public void getAddedSaleDetail() {
		newSale = new Sale(45678L, employee, customer);
		SaleProductDetail detail;
		// This sale can't be modified
		try {
			newSale.addProducts(product, 18);
			newSale.addProducts(productTwo, 18);
			detail = newSale.getSaleProductDetail(productTwo);
			assertThat(detail.getProductCase().getCaseProductId(), equalTo(productTwo.getCaseProductId()));
		} catch (SaleModificationException e) {
			assertThat(e.getClass(), equalTo(SaleModificationException.class));
		}
	}

	@After
	public void tearDown() {
		customer = null;
		product = null;
		productTwo = null;
		detail = null;
		employee = null;
		assertNull(product);
		assertNull(customer);
		assertNull(productTwo);
		assertNull(detail);
		assertNull(employee);
	}
}
