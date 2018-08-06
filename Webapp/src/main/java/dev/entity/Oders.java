package dev.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "oders")
public class Oders {
	@Id
	@GeneratedValue
	private Integer id;
	private Float total;
	private Integer status;
	private String note;
	private Integer quantity;
	
	@OneToMany(mappedBy="oders",fetch=FetchType.EAGER)
	private List<OderDetails> lstOrderDetail;

	public List<OderDetails> getLstOrderDetail() {
		return lstOrderDetail;
	}

	public void setLstOrderDetail(List<OderDetails> lstOrderDetail) {
		this.lstOrderDetail = lstOrderDetail;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = false)
	private Users users;

	public Oders(Integer id, Float total, Integer status, String note, Integer quantity, Users users) {
		super();
		this.id = id;
		this.total = total;
		this.status = status;
		this.note = note;
		this.quantity = quantity;
		this.users = users;
	}

	public Oders() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

}
