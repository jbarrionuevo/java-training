package edu.globant.finalProject.service;

import edu.globant.finalProject.model.Case.Case;
import edu.globant.finalProject.model.Provider.Provider;
import edu.globant.finalProject.model.Sale.Sale;

public interface LogisticService {
	public void orderToProvider(Provider p, Case c);
	public void registerASale(Sale s);
}
