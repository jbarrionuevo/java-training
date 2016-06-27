package edu.globant.com.javaFinalProject.model;

public enum SellerTypeEnum {

		 
	    STORE("Store"),
	    DELIVERY("Delivery"),
		STORE_DELIVERY("Store and Delivery");
	     
	    private String sellerType;
	     
	    private SellerTypeEnum(final String sellerType){
	        this.sellerType = sellerType;
	    }
	     
	    public String getSellerType(){
	        return this.sellerType;
	    }
	 
	    @Override
	    public String toString(){
	        return this.sellerType;
	    }
	 
	    public String getName(){
	        return this.name();
	    }
	 
}
