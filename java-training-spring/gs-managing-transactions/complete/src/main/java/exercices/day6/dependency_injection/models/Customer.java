package exercices.day6.dependency_injection.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.thymeleaf.util.Validate;

import exercices.day6.dependency_injection.enums.Gender;

@Entity
public class Customer extends ThirdPartyParticipant{

	private int age;
	private Gender gender;
	
	public Customer(String name, String location, int age, Gender gender) {
		super(name,location);
		Validate.notNull(gender, "Gender cannot be blank");
		this.age = age;
		this.gender = gender;
	}
	
	@Override
	public String toString(){
		return String.format("Name: %s, Location: %s, Age: %d, Gender: %s", 
				this.getName(), this.getLocation(), this.getAge(), this.getGender());
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	
}
