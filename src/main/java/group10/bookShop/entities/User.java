package group10.bookShop.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue
	@Column(name = "id", nullable = false)  // mapping đến cột id trong table dattabase
	private Integer id;
	
	@NotEmpty
	@Column(name = "ten", nullable = false)  // mapping đến cột id trong table dattabase
	private String name;

	@NotEmpty
	@Column(name = "ho", nullable = false)  // mapping đến cột id trong table dattabase
	private String ho;
	
	@NotEmpty
	@Column(name = "email", nullable = false)  // mapping đến cột id trong table dattabase
	private String email;
	
	@NotEmpty
	@Column(name = "matkhau", nullable = false)  // mapping đến cột id trong table dattabase
	private String matkhau;
	
	@NotNull
	@Column(name = "sdt", nullable = false)  // mapping đến cột id trong table dattabase
	private Integer sdt;

	public User() {
		
	}

	public User(Integer id, @NotEmpty String name, @NotEmpty String ho, @NotEmpty String email,
			@NotEmpty String matkhau, @NotNull Integer sdt) {
		super();
		this.id = id;
		this.name = name;
		this.ho = ho;
		this.email = email;
		this.matkhau = matkhau;
		this.sdt = sdt;
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

	public String getHo() {
		return ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMatkhau() {
		return matkhau;
	}

	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}

	public Integer getSdt() {
		return sdt;
	}

	public void setSdt(Integer sdt) {
		this.sdt = sdt;
	}
	
	
}
