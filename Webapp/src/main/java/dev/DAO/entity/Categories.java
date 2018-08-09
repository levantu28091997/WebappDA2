package dev.DAO.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "categories")
public class Categories {
	@Id
	@GeneratedValue
	private Integer id;
	@NotBlank(message="Danh mục không được để trống")
	private String name;
	@OneToMany(mappedBy = "categories", fetch = FetchType.LAZY)
	private Collection<Product> product;

	public Categories(Integer id, String name, Collection<Product> product) {
		super();
		this.id = id;
		this.name = name;
		this.product = product;
	}

	public Categories() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Product> getProduct() {
		return product;
	}

	public void setProduct(Collection<Product> product) {
		this.product = product;
	}

}
