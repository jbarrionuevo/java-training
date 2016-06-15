package edu.globant.day1.exercises.ddd;

import org.joda.time.LocalDate;

public class Sale {

	private int id;
	private Customer customer;
	private Seller seller;
	private LocalDate date;
	private SellDetail sellDetail;
	private String status = SaleStatusEnum.DRAFT.getSaleStatus();
	private Store store;
	private double totalPrice;
	
	public Sale(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public SellDetail getSellDetail() {
		return sellDetail;
	}

	public void setSellDetail(SellDetail sellDetail) {
		this.sellDetail = sellDetail;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Sale [id=" + id + ", customer=" + customer + ", seller=" + seller + ", date=" + date + ", sellDetail="
				+ sellDetail + ", status=" + status + ", store=" + store + ", totalPrice=" + totalPrice + "]";
	}
	
	
	
}
