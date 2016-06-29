package edu.globant.finalProject.service;

import java.util.ArrayList;

import edu.globant.finalProject.model.Case.Case;
import edu.globant.finalProject.model.Provider.Order;
import edu.globant.finalProject.model.Provider.Provider;

public interface LogisticService {
	public Order createAnOrder(Provider provider);
	public Order orderToProvider(Order order,ArrayList<Case> cases);
	public void registerAnOrder(Order order);
}
