package edu.globant.finalproject.hibernate;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import edu.globant.finalproject.model.Provider.OrderDTO;

@Entity
@Table(name = "provider")
public class Provider extends BaseEntity{
	
	private Provider(){}
	
	@Column(name = "name")
	protected String name;
	
	//protected ArrayList<OrderDTO> orders;
}
