package dev.DAO.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "oder_details")
public class OderDetails {
	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pro_id", nullable = false)
	private Product product;

	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "total")
	private Float total;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "oder_id", nullable = false)
	private Oders oders;

	public OderDetails(Integer id, Product product, Integer quantity, Oders oders) {
		super();
		this.id = id;
		this.product = product;
		this.quantity = quantity;
		this.oders = oders;
	}

	public OderDetails() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public Oders getOders() {
		return oders;
	}

	public void setOders(Oders oders) {
		this.oders = oders;
	}

}
