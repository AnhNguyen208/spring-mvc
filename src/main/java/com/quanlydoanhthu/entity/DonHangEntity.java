package com.quanlydoanhthu.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Don_Hang")
public class DonHangEntity extends BaseEntity{
	@Column(name = "ThongTinKhachHang")
	private String thongTinKhachHangString;
	
	@Column(name = "ChietKhau")
	private Long chietKhauLong;
	
	public Long getChietKhauLong() {
		return chietKhauLong;
	}

	public void setChietKhauLong(Long chietKhauLong) {
		this.chietKhauLong = chietKhauLong;
	}
    
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="idNhanVien")
	private NhanVienEntity nhanVienEntity;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "donHangEntity")
    List<DonHangSanPhamEntity> donHangSanPhamEntities;

	public String getThongTinKhachHangString() {
		return thongTinKhachHangString;
	}
	public void setThongTinKhachHangString(String thongTinKhachHangString) {
		this.thongTinKhachHangString = thongTinKhachHangString;
	}
	public NhanVienEntity getNhanVienEntity() {
		return nhanVienEntity;
	}
	public void setNhanVienEntity(NhanVienEntity nhanVienEntity) {
		this.nhanVienEntity = nhanVienEntity;
	}
	public List<DonHangSanPhamEntity> getDonHangSanPhamEntities() {
		return donHangSanPhamEntities;
	}
	public void setDonHangSanPhamEntities(List<DonHangSanPhamEntity> donHangSanPhamEntities) {
		this.donHangSanPhamEntities = donHangSanPhamEntities;
	}
}
