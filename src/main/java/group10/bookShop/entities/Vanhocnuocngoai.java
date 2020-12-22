package group10.bookShop.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

@Entity
@Table(name="vanhocnuocngoai")
public class Vanhocnuocngoai {
	@Id
	@Column(name = "Masach", nullable = false)  // mapping đến cột id trong table dattabase
	private Integer masach;
	
	@NotEmpty   // không được bỏ trống
	@Size(max=70)  // nhập không quá 50 kí tự
	@Column(name = "Tensach", nullable = false)
	private String tensach;
	
	@NotEmpty   // không được bỏ trống
	@Size(max=70)  // nhập không quá 50 kí tự
	@Column(name = "Tacgia", nullable = false)
	private String tacgia;
	
	@NotEmpty   // không được bỏ trống
	@Size(max=20)  // nhập không quá 50 kí tự
	@Column(name = "Theloai", nullable = false)
	private String theloai;
	
	@NotNull
	@Column(name = "Giaca", nullable = false)
	private Double giaca;
	
	@Column(name = "Mota", nullable = false)
	private String mota;
	
	@NotEmpty   // không được bỏ trống
	@Column(name = "Hinhanh", nullable = false)
	private String hinhanh;
	
	@NotNull   // không được bỏ trống
	@Column(name = "Tonkho", nullable = false)
	@NumberFormat
	private int tonkho;
	
	@NotNull  // không được bỏ trống
	@Column(name = "Soluongdaban", nullable = false)
	@NumberFormat
	private int soluongdaban;
	
	@Column(name = "Ngayxuatban", nullable = false)
	private LocalDateTime ngayxuatban;

	public Vanhocnuocngoai() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vanhocnuocngoai(Integer masach, @NotEmpty @Size(max = 50) String tensach,
			@NotEmpty @Size(max = 20) String tacgia, @NotEmpty @Size(max = 20) String theloai, @NotNull Double giaca,
			String mota, @NotEmpty String hinhanh, @NotNull int tonkho, @NotNull int soluongdaban,
			LocalDateTime ngayxuatban) {
		super();
		this.masach = masach;
		this.tensach = tensach;
		this.tacgia = tacgia;
		this.theloai = theloai;
		this.giaca = giaca;
		this.mota = mota;
		this.hinhanh = hinhanh;
		this.tonkho = tonkho;
		this.soluongdaban = soluongdaban;
		this.ngayxuatban = ngayxuatban;
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

	public String getTacgia() {
		return tacgia;
	}

	public void setTacgia(String tacgia) {
		this.tacgia = tacgia;
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

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public String getHinhanh() {
		return hinhanh;
	}

	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}

	public int getTonkho() {
		return tonkho;
	}

	public void setTonkho(int tonkho) {
		this.tonkho = tonkho;
	}

	public int getSoluongdaban() {
		return soluongdaban;
	}

	public void setSoluongdaban(int soluongdaban) {
		this.soluongdaban = soluongdaban;
	}

	public LocalDateTime getNgayxuatban() {
		return ngayxuatban;
	}

	public void setNgayxuatban(LocalDateTime ngayxuatban) {
		this.ngayxuatban = ngayxuatban;
	}
}
