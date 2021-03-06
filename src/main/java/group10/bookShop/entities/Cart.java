package group10.bookShop.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="hoadon")
public class Cart {
	
	@Id
	@Column(name = "madonhang", nullable = false)  // mapping đến cột id trong table dattabase
	private int madonhang;
	
	@Column(name = "Masach", nullable = false)  // mapping đến cột id trong table dattabase
	private Integer masach;
	
	@NotEmpty   // không được bỏ trống
	@Size(max=70)  // nhập không quá 50 kí tự
	@Column(name = "Tensach", nullable = false)
	private String tensach;
	
	@NotEmpty   // không được bỏ trống
	@Size(max=70)  // nhập không quá 50 kí tự
	@Column(name = "Tennguoimua", nullable = false)
	private String tennguoimua;
	
	
	@NotEmpty   // không được bỏ trống
	@Size(max=20)  // nhập không quá 50 kí tự
	@Column(name = "Theloai", nullable = false)
	private String theloai;
	
	@NotNull
	@Column(name = "sotien", nullable = false)
	private Double giaca;
	
	@NotNull
	@Column(name = "Soluong", nullable = false)
	private int soluong;
	
	@Size(max=10)
	@NotEmpty
	@Column(name = "sdtnguoimua", nullable = false)
	private String sodienthoainguoimua;
	
	@NotEmpty
	@Column(name = "email")  // maping trường fullname với cột Full_Name trong bảng bankAccount
	private String emailnguoimua;
	
	@NotEmpty   // không được bỏ trống
	@Column(name = "Hinhanh", nullable = false)
	private String hinhanh;
	
	@NotEmpty   // không được bỏ trống
	@Size(max=70)  // nhập không quá 50 kí tự
	@Column(name = "Diachi", nullable = false)
	private String diachi;
	
	@Column(name = "ngayxuathoadon", nullable = false)
	private LocalDateTime ngayxuatban;

	public Cart() {
		int uniqueId = (int) (System.currentTimeMillis() & 0xfffffff);
		this.madonhang = uniqueId;
	}

	public Cart(int madonhang, Integer masach, @NotEmpty @Size(max = 70) String tensach,
			@NotEmpty @Size(max = 70) String tennguoimua, @NotEmpty @Size(max = 20) String theloai,
			@NotNull Double giaca, @NotNull @NotNull int soluong, @Size(max = 10) @NotNull @Size(max = 10) @NotEmpty String sodienthoainguoimua,
			@Email String emailnguoimua, @NotEmpty String hinhanh, @NotEmpty @Size(max = 70) String diachi,
			LocalDateTime ngayxuatban) {
		super();
		this.madonhang = madonhang;
		this.masach = masach;
		this.tensach = tensach;
		this.tennguoimua = tennguoimua;
		this.theloai = theloai;
		this.giaca = giaca;
		this.soluong = soluong;
		this.sodienthoainguoimua = sodienthoainguoimua;
		this.emailnguoimua = emailnguoimua;
		this.hinhanh = hinhanh;
		this.diachi = diachi;
		this.ngayxuatban = ngayxuatban;
	}

	public int getMadonhang() {
		return madonhang;
	}

	public void setMadonhang(int madonhang) {
		this.madonhang = madonhang;
	}

	public Integer getMasach() {
		return masach;
	}

	public void setMasach(Integer masach) {
		this.masach = masach;
	}

	public String getTensach() {
		return tensach;
	}

	public void setTensach(String tensach) {
		this.tensach = tensach;
	}

	public String getTennguoimua() {
		return tennguoimua;
	}

	public void setTennguoimua(String tennguoimua) {
		this.tennguoimua = tennguoimua;
	}

	public String getTheloai() {
		return theloai;
	}

	public void setTheloai(String theloai) {
		this.theloai = theloai;
	}

	public Double getGiaca() {
		return giaca;
	}

	public void setGiaca(Double giaca) {
		this.giaca = giaca;
	}

	public @NotNull int getSoluong() {
		return soluong;
	}

	public void setSoluong(@NotNull int soluong) {
		this.soluong = soluong;
	}

	public @Size(max = 10) @NotEmpty String getSodienthoainguoimua() {
		return sodienthoainguoimua;
	}

	public void setSodienthoainguoimua(@Size(max = 10) @NotEmpty String sodienthoainguoimua) {
		this.sodienthoainguoimua = sodienthoainguoimua;
	}

	public String getEmailnguoimua() {
		return emailnguoimua;
	}

	public void setEmailnguoimua(String emailnguoimua) {
		this.emailnguoimua = emailnguoimua;
	}

	public String getHinhanh() {
		return hinhanh;
	}

	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public LocalDateTime getNgayxuatban() {
		return ngayxuatban;
	}

	public void setNgayxuatban(LocalDateTime ngayxuatban) {
		this.ngayxuatban = ngayxuatban;
	}

	

	
}
