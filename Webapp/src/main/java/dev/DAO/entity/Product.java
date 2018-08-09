package dev.DAO.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue
	private Integer id;
	@NotBlank(message = "Tên sản phẩm không được để trống")
	private String name;
	@NotNull(message = "Giá không được bỏ trống")
	@Min(value = 0, message = "Giá không được bé hơn 0")
	private Float price;
	@NotBlank(message = "Ảnh không được để trống")
	@URL(message = "Yêu cầu nhập link ảnh")
	private String image;
	@NotBlank(message = "Gới thiệu không được để trống")
	@Length(min = 10, message = "Gới thiệu ít nhất 10 kí tự")
	private String intro;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@Column(name = "created_at")
	private Date createdAt;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@Column(name = "updated_at")
	private Date updatedAt;
	@ManyToOne
	@JoinColumn(name = "cate_id")
	private Categories categories;

	public Product(Integer id, String name, Float price, String image, String intro, Date createdAt, Date updatedAt,
			Categories categories) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.image = image;
		this.intro = intro;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.categories = categories;
	}

	public Product() {
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

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Categories getCategories() {
		return categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}

}
