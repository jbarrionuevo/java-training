package classes;

import java.util.Collection;

public class CaseSeller extends Employee {
	
	private Collection<Sale> sales;
	private Logistic logistic; //to tell him to decrement when selling a product
	
	public CaseSeller(){}
	
	public CaseSeller(Collection<Sale> sales, Logistic logistic) {
		super();
		this.sales = sales;
		this.logistic = logistic;
	}

	public void registerOrder(StoreOrder order){
		Sale newSale = new Sale(order);
		this.sales.add(newSale);
	}
	

	public Collection<Sale> getSales() {
		return sales;
	}

	public void setSales(Collection<Sale> sales) {
		this.sales = sales;
	}
	
	public Collection<Order> getOrders(){
		return (Collection<Order>) this.sales.stream().map(sale->sale.getOrder());
	}

	public Logistic getLogistic() {
		return logistic;
	}

	public void setLogistic(Logistic logistic) {
		this.logistic = logistic;
	}
	
	
}
