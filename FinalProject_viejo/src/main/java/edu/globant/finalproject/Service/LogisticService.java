package edu.globant.finalproject.Service;

import java.util.ArrayList;

import edu.globant.finalproject.model.Case.CaseDTO;
import edu.globant.finalproject.model.Provider.OrderDTO;
import edu.globant.finalproject.model.Provider.ProviderDTO;


public interface LogisticService {
	public OrderDTO createAnOrder(ProviderDTO provider);
	public OrderDTO orderToProvider(OrderDTO order,ArrayList<CaseDTO> cases);
	public void registerAnOrder(OrderDTO order);
}
