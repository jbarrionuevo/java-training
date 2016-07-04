package edu.globant.IONSolid.services;

public abstract class SearchCriteria {

	public enum OrderRegister {
		ASC, DESC;
	}
	
	private OrderRegister registerOrder;
	
	public void setRegisterOrder(OrderRegister order) {
		this.registerOrder = order;
	}
	
	public OrderRegister getRegisterOrder() {
		return this.registerOrder = this.registerOrder;
	}
}
