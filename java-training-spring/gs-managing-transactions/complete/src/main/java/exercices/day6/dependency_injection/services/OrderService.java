package exercices.day6.dependency_injection.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import exercices.day6.dependency_injection.daos.OrderDao;
import exercices.day6.dependency_injection.models.Case;
import exercices.day6.dependency_injection.models.Order;
import hello.BookingService;
@Service
public class OrderService{
	
	private final static Logger log = LoggerFactory.getLogger(OrderService.class);
	
	@Autowired
	private OrderDao orderDao;
	
	@Transactional
	public void saveOrders(Order... orders){
		 for (Order order: orders) {
	            log.info("Persisting Order [" + order + "] to database...");
	            orderDao.save(order);
	     }
	}
	
	public void saveOrder(Order order){
		orderDao.save(order);
	}
	
	public Collection<Order> findAllOrders() {
	        return orderDao.findAll();
	}
	
	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
}
