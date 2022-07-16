package com.quanlydoanhthu.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "San_Pham")
public class SanPhamEntity extends BaseEntity{
	@Column(name = "TenSanPham")
	private String tenSanPhamString;
	
	@Column(name = "AnhDaiDienSP")
	private String anhDaiDienString;
	
	@Column(name = "MauSac")
	private String mauSacString;
	
	@Column(name = "kichCo")
	private String kichCoString;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idLoaiSP")
	private LoaiSPEntity loaiSPEntity;
	
	@Column(name = "GiaBan")
	private Long giaBanLong;
	
	@Column(name = "GiaNhap")
	private Long giaNhapLong;
	
	@Column(name = "SoLuong")
	private Integer soLuongInteger;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idHang")
	private HangEntity hangEntity;
	
	@OneToMany(mappedBy = "sanPhamEntity")
    List<DonHangSanPhamEntity> donHangSanPhamEntities;
	
	@OneToMany(mappedBy = "sanPhamEntity")
    List<NhapHangSanPhamEntity> nhapHangSanPhamEntities;
	
	public String getMauSacString() {
		return mauSacString;
	}
	public void setMauSacString(String mauSacString) {
		this.mauSacString = mauSacString;
	}
	public String getKichCoString() {
		return kichCoString;
	}
	public void setKichCoString(String kichCoString) {
		this.kichCoString = kichCoString;
	}
	public Long getGiaNhapLong() {
		return giaNhapLong;
	}
	public void setGiaNhapLong(Long giaNhapLong) {
		this.giaNhapLong = giaNhapLong;
	}
	public List<NhapHangSanPhamEntity> getNhapHangSanPhamEntities() {
		return nhapHangSanPhamEntities;
	}
	public void setNhapHangSanPhamEntities(List<NhapHangSanPhamEntity> nhapHangSanPhamEntities) {
		this.nhapHangSanPhamEntities = nhapHangSanPhamEntities;
	}
	public List<DonHangSanPhamEntity> getDonHangSanPhamEntities() {
		return donHangSanPhamEntities;
	}
	public void setDonHangSanPhamEntities(List<DonHangSanPhamEntity> donHangSanPhamEntities) {
		this.donHangSanPhamEntities = donHangSanPhamEntities;
	}
	public Integer getSoLuongInteger() {
		return soLuongInteger;
	}
	public void setSoLuongInteger(Integer soLuongInteger) {
		this.soLuongInteger = soLuongInteger;
	}
	public String getTenSanPhamString() {
		return tenSanPhamString;
	}
	public void setTenSanPhamString(String tenSanPhamString) {
		this.tenSanPhamString = tenSanPhamString;
	}
	public String getAnhDaiDienString() {
		return anhDaiDienString;
	}
	public void setAnhDaiDienString(String anhDaiDienString) {
		this.anhDaiDienString = anhDaiDienString;
	}
	public Long getGiaBanLong() {
		return giaBanLong;
	}
	public void setGiaBanLong(Long giaBanLong) {
		this.giaBanLong = giaBanLong;
	}
	public LoaiSPEntity getLoaiSPEntity() {
		return loaiSPEntity;
	}
	public void setLoaiSPEntity(LoaiSPEntity loaiSPEntity) {
		this.loaiSPEntity = loaiSPEntity;
	}
	public HangEntity getHangEntity() {
		return hangEntity;
	}
	public void setHangEntity(HangEntity hangEntity) {
		this.hangEntity = hangEntity;
	}
	
}
