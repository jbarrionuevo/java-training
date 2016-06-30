package domain;

import javax.persistence.Entity;

import org.apache.commons.lang3.Validate;
import org.hibernate.annotations.DynamicUpdate;

import persistence.DAO.DTO;

@Entity
public class Employee extends BaseEntity implements DTO {

	private String name;
	private String type;

	public Employee(String name, String type) {
		Validate.notBlank(name, "The name cannot be blank.");
		Validate.notBlank(type, "The type cannot be blank.");
		Validate.notNull(name, "The name cannot be null.");
		Validate.notNull(type, "The type cannot be null.");
		this.name = name;
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		Validate.notBlank(type, "The type cannot be blank.");
		Validate.notNull(type, "The type cannot be null.");
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		Validate.notBlank(name, "The name cannot be blank.");
		Validate.notNull(name, "The name cannot be null.");
		this.name = name;
	}

}
