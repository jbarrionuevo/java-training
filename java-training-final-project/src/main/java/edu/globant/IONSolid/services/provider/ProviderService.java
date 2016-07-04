package edu.globant.IONSolid.services.provider;

import java.util.Date;
import java.util.List;

import edu.globant.IONSolid.model.order.Order;
import edu.globant.IONSolid.model.provider.Provider;
import edu.globant.IONSolid.services.SearchCriteria;

public interface ProviderService {

	public List<Provider> getOrdersAmount(SearchCriteria criteria);
	
	public Order getOrder(Long orderId);
	
	public void setDeliveryDateToOrder(Order order, Date date);
	
	public void searchProviderByProductAmount();
	
}
