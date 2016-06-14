package dia1.models;

import java.util.ArrayList;
import java.util.Collection;

public class Provider {
	private Collection<Order> orders;

	public Provider(){
		this.orders = new ArrayList<Order>();
	}
	
	public Collection<Order> getOrders() {
		return orders;
	}

	public void setOrders(Collection<Order> orders) {
		this.orders = orders;
	}
	
//	public void deliver(Order order, Logistic destiny) {
//		destiny.receiveCaseFromProvider(order);
//	}
	
	public void addOrder(Order order){
		this.orders.add(order);
	}
	
	
}
