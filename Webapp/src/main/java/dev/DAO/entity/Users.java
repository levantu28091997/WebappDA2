package dev.DAO.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "users")
public class Users {
	@Id
	@GeneratedValue
	private Integer id;
	@NotBlank(message="Name không được để trống")
	private String name;
	@NotBlank(message="Name không được để trống")
	@Email(message="Email sai định dạng")
	private String email;
	@NotBlank(message="Password không được để trống")
	private String password;
	@NotBlank(message="Phone không được để trống")
	@Pattern(regexp="^[0-9]{10,11}$$",message="Phone không hợp lệ")
	private String phone;
	@NotBlank(message="Địa chỉ không được để trống")
	private String address;

	@OneToMany(mappedBy = "users")
	private Collection<Oders> oder;

	public Users(Integer id, String name, String email, String password, String phone, String address,
			Collection<Oders> oder) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.oder = oder;
	}

	public Users() {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Collection<Oders> getOder() {
		return oder;
	}

	public void setOder(Collection<Oders> oder) {
		this.oder = oder;
	}

}
