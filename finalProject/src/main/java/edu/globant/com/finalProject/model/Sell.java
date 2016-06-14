package edu.globant.com.finalProject.model;

import java.util.Date;

import org.joda.time.LocalDate;

public class Sell {

	private int id;
	private Customer customer;
	private Seller seller;
	private LocalDate date;
	private SellDetail sellDetail;
	private String status = SellStatusEnum.DRAFT.getSellStatus();
	private Store store;
	private double totalPrice;
	
}
