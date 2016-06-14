package dia1.services;

import java.util.Collection;

import dia1.models.Case;

public class AlertService {
	
	//method to be executed authomatically once in a while
	public Collection<Case> casesWhichNeedStock(){
		System.out.println("return the cases which need more stock");
		//alert logistic team about this
		return null;
	}
}
