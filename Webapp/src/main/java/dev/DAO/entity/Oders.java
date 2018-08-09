package dev.DAO.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "oders")
public class Oders {
	@Id
	@GeneratedValue
	private Integer id;
	private Float total;
	private Integer status;
	private String note;

	@Column(name = "date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date date;

	@OneToMany(mappedBy = "oders", fetch = FetchType.LAZY)
	private List<OderDetails> lstOrderDetail;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private Users users;

	public Oders(Integer id, Float total, Integer status, String note, Integer quantity, Users users) {
		super();
		this.id = id;
		this.total = total;
		this.status = status;
		this.note = note;
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

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<OderDetails> getLstOrderDetail() {
		return lstOrderDetail;
	}

	public void setLstOrderDetail(List<OderDetails> lstOrderDetail) {
		this.lstOrderDetail = lstOrderDetail;
	}

}
