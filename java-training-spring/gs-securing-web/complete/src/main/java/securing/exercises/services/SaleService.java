package securing.exercises.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import securing.exercises.services.Sale;
import securing.exercises.services.SaleEmployee;

class SaleDAO {

	public List<Sale> retrieveSales() {
		List<Sale> todaySales = new ArrayList<Sale>();

		todaySales.add(new Sale("XCO90", new SaleEmployee("Pablo")));
		todaySales.add(new Sale("XCO91", new SaleEmployee("Guillermo")));
		todaySales.add(new Sale("XCO92", new SaleEmployee("Maria")));
		todaySales.add(new Sale("XCO93", new SaleEmployee("Maria")));
		todaySales.add(new Sale("XCO94", new SaleEmployee("Pablo")));
		todaySales.add(new Sale("XCO95", new SaleEmployee("Guillermo")));
		todaySales.add(new Sale("XCO96", new SaleEmployee("Pablo")));

		return todaySales;
	}

	public List<Sale> retrieveSalesByName(String name) {
		List<Sale> todaySales = new ArrayList<Sale>();

		todaySales = this.retrieveSales();
		return todaySales.stream().filter(s -> s.getEmployee().getName().equals(name)).collect(Collectors.toList());
	}
}

@Service
public class SaleService {

	public List<Sale> getAllSales() {
		SaleDAO dao = new SaleDAO();

		return dao.retrieveSales();
	}

	public List<Sale> getAllSalesByName(String name) {
		SaleDAO dao = new SaleDAO();

		return dao.retrieveSalesByName(name);

	}
}
