package ilan.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrderAlert {
	@Id
	@GeneratedValue
	private Long id;
	private int quantity;
	private Long productId;
	
	public OrderAlert(){}
	
	public OrderAlert(int quantity, Long productId) {
		super();
		this.quantity = quantity;
		this.productId = productId;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	
}
