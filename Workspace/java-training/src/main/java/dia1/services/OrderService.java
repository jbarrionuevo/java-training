package dia1.services;

import dia1.daos.OrderDao;
import dia1.models.Order;
import dia1.models.Provider;

public class OrderService {
	
	private OrderDao orderDao;
	

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
}
