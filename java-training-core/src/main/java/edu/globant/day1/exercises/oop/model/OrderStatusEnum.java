package edu.globant.day1.exercises.oop.model;

public enum OrderStatusEnum {

	ORDERED("Ordered"),
	DELAYED("Delayed"),
	DELIVERED("Delivered");
        
    private String orderStatus;
     
    private OrderStatusEnum(final String orderStatus){
        this.orderStatus = orderStatus;
    }
     
    public String getOrderStatus(){
        return this.orderStatus;
    }
 
    @Override
    public String toString(){
        return this.orderStatus;
    }
 
    public String getName(){
        return this.name();
    }
	
}
