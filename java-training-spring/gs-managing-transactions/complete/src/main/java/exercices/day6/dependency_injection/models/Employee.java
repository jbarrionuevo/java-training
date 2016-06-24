package exercices.day6.dependency_injection.models;

import org.thymeleaf.util.Validate;

public abstract class Employee {
	private String name;
	
	public Employee(){}
	
	public Employee(String name){
		Validate.notEmpty(name, "Name cannot be empty");
		this.name=name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
