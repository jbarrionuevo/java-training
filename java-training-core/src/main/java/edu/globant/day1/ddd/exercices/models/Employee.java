package edu.globant.day1.ddd.exercices.models;

public abstract class Employee {
	private String name;
	private int id;
	
	public Employee(){}
	
	public Employee(String name){
		this.name=name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
