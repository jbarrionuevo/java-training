package edu.globant.day2.collections.exercices.map;

public class Person implements Comparable{
	private String firstName,lastName;

	
	public Person(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString(){
		return String.format("%s, %s", this.getLastName(), this.getFirstName());
	}
	@Override
	public int compareTo(Object otherPerson) {
		// TODO Auto-generated method stub
		return this.getLastName().compareTo(((Person)otherPerson).getLastName());
	}
	
	
}
