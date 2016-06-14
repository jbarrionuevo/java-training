package edu.globant.com.finalProject.model;

public enum SellStatusEnum {

	DRAFT("Draft"),
    PAID("Paid"),
	CANCELLED("Cancelled"),
	REFUND("Refund");
     
    private String sellStatus;
     
    private SellStatusEnum(final String sellStatus){
        this.sellStatus = sellStatus;
    }
     
    public String getSellStatus(){
        return this.sellStatus;
    }
 
    @Override
    public String toString(){
        return this.sellStatus;
    }
 
    public String getName(){
        return this.name();
    }
	
}
