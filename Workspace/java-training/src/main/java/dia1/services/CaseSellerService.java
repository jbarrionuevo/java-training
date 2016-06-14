package dia1.services;

import java.util.Collection;

import dia1.daos.CaseSellerDao;
import dia1.models.CaseSeller;
import dia1.models.Order;
import dia1.models.Sale;

public class CaseSellerService {
	
	private CaseSellerDao caseSellerDao;

	public void addOrderToSeller(Order order, CaseSeller seller){
		Sale newSale = new Sale(order);
		seller.addSale(newSale);
		System.out.println("Add order to seller "+seller.getName());
		//update seller in db
	}
	
	public Collection<Order> getOrders(CaseSeller seller){
		return (Collection<Order>) seller.getSales().stream().map(sale->sale.getOrder());
	}
	
	public CaseSellerDao getCaseSellerDao() {
		return caseSellerDao;
	}

	public void setCaseSellerDao(CaseSellerDao caseSellerDao) {
		this.caseSellerDao = caseSellerDao;
	}
	
}
