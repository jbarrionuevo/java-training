package transactions.excercices;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import dependencyInjection.excercices.Sale;
import dependencyInjection.excercices.SaleEmployee;

public class SaleDAO {

	private final static Logger log = LoggerFactory.getLogger(SaleDAO.class);

	@Autowired
	JdbcTemplate template;

	/*
	 * When a new sale with an employee that is not registered on the
	 * employees table is found I catch the exception and make an insertion
	 * on the employees table for the new employee and then I register the
	 * sale. Because I make two insertions I need to use the Transactional
	 * annotation in order to keep the database consistent.
	 * */
	@Transactional
	public void insertSale(List<Sale> todaySales) {
		for (Sale sale : todaySales) {
			log.info("Inserting the " + sale.getSaleId() + " sale made by " + sale.getEmployee().getName());
			try {
				template.update(
						"INSERT INTO `sales`(`saleId`, `saleState`, `employeeId`) VALUES (?,?, (select `employeeId` from employees where name = ?))",
						sale.getSaleId(), sale.getState().toString(), sale.getEmployee().getName());
			} catch (DataAccessException e) {
				template.update(
						"INSERT INTO employees(name) VALUES (?)", sale.getEmployee().getName()
						);
				template.update(
						"INSERT INTO sales(saleId, saleState, employeeId) VALUES (?,?, (select employeeId from employees where name = ?))",
						sale.getSaleId(), sale.getState().toString(), sale.getEmployee().getName());
				log.info(e.getLocalizedMessage());
				log.info("Catched Exception and inserting the " + sale.getSaleId() + " sale made by " + sale.getEmployee().getName());
			}
		}
	}

	// Returns all the sales
	public List<Sale> findAllSales() {
		return template.query(
				"SELECT `saleId`, `saleState`, s.`employeeId`, `name` FROM `sales` s , `employees` e WHERE s.employeeId = e.employeeId",
				new RowMapper<Sale>() {
					@Override
					public Sale mapRow(ResultSet rs, int rowNum) throws SQLException {
						SaleEmployee emp = new SaleEmployee(rs.getString("name"));
						Sale sale = new Sale(rs.getString("saleId"), emp);
						return sale;
					}
				});
	}
}