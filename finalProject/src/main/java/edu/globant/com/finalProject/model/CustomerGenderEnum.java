package edu.globant.com.finalProject.model;

public enum CustomerGenderEnum {

	MALE("Male"),
    FEMALE("Female");
	
    private String customerGender;
     
    private CustomerGenderEnum(final String customerGender){
        this.customerGender = customerGender;
    }
     
    public String getCustomerGender(){
        return this.customerGender;
    }
 
    @Override
    public String toString(){
        return this.customerGender;
    }
 
    public String getName(){
        return this.name();
    }
    
}
