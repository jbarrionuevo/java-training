package edu.globant.day1.multi_tier_applications.exercices.layers.dtos;

import java.util.ArrayList;
import java.util.Collection;

import javax.validation.Valid;

public class ProviderDTO extends ThirdPartyParticipantDTO{
	@Valid
	private Collection<OrderDTO> orders;
	
	public ProviderDTO(String name,String location){
		super(name,location);
		this.orders = new ArrayList<OrderDTO>();
	}
	
	public Collection<OrderDTO> getOrders() {
		return orders;
	}

	public void setOrders(Collection<OrderDTO> orders) {
		this.orders = orders;
	}
	
	public void addOrder(OrderDTO order){
		this.orders.add(order);
	}	
	
}
