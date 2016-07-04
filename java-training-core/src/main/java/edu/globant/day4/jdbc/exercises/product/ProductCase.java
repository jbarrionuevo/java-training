package edu.globant.day4.jdbc.exercises.product;

import java.util.Date;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class ProductCase {

	// unique id for every product
	private Long caseProductId;
	private Queue<Price> unitPriceHistory;
	private String name;
	private CaseDevice device;
	private CaseDesign design;

	public ProductCase(Long itemId, String name, CaseDevice device, CaseDesign design, Price price, Integer stock) {
		this.unitPriceHistory = new LinkedList<Price>();
		this.caseProductId = itemId;
		this.unitPriceHistory.add(price);
		this.device = device;
		this.design = design;
	}

	public void setNewUnitPrice(Price price) {
		this.unitPriceHistory.add(price);
	}
	
	public Double getUnitPriceForCurrentDate() {
		//Retrieves last price
		Price p = unitPriceHistory.peek();
		return p.getPricePerUnit();
	}

	public Double getUnitPriceForDate(Date date, Integer quantity) {
		Price tmpPrice;
		
		tmpPrice = this.getDate(date);
		if(tmpPrice != null) {
			return tmpPrice.calculatePrice(quantity);
		}		
		tmpPrice = unitPriceHistory.peek();
		return tmpPrice.calculatePrice(quantity);
	}
	
	private Price getDate(Date date) {
		Deque<Price> stack = new LinkedList<Price>();
		Price tmpPrice = null;
		int res;
		
		//Take elements from the queue
		while(!unitPriceHistory.isEmpty()) {
			tmpPrice = unitPriceHistory.poll();			
			res = tmpPrice.getApplicationDate().compareTo(date);
			if(res <= 0) {
				break;
			}
		}
		//Rebuild queue
		while(!stack.isEmpty()) {
			unitPriceHistory.add(stack.pop());
		}	

		return tmpPrice;		
	}
	
	public Long getCaseProductId() {
		return caseProductId;
	}

	public String getName() {
		return name;
	}

	public CaseDevice getDevice() {
		return device;
	}

	public CaseDesign getDesign() {
		return design;
	}
}
