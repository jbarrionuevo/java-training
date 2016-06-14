package dia1.services;

import dia1.auxiliary_classes.DateMethods;
import dia1.daos.OrderDao;
import dia1.models.Order;
import dia1.models.Provider;

public class OrderService {
	
	private OrderDao orderDao;
	
	public int delay(Order order){
		if(order.getDateOfDelivery()==null) return -1;
		int difference = DateMethods.differenceBetweenDates(order.getDateOfRequest(), order.getDateOfDelivery());
		if(difference>30) return difference-30;
		return 0;
	}
	
	public boolean deliveredOnTime(Order order){
		if(order.getDateOfDelivery()==null) return false;
		return DateMethods.differenceBetweenDates(order.getDateOfRequest(), order.getDateOfDelivery())<30; //we assume that after 30 days, the delivery is late
	}
	
	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
}
