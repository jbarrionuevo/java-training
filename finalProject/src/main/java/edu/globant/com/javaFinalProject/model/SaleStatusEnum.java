package edu.globant.com.javaFinalProject.model;

public enum SaleStatusEnum {

	DRAFT("Draft"),
    PAID("Paid"),
	CANCELLED("Cancelled"),
	REFUND("Refund");
     
    private String saleStatus;
     
    private SaleStatusEnum(final String saleStatus){
        this.saleStatus = saleStatus;
    }
     
    public String getSaleStatus(){
        return this.saleStatus;
    }
 
    @Override
    public String toString(){
        return this.saleStatus;
    }
 
    public String getName(){
        return this.name();
    }
	
}
