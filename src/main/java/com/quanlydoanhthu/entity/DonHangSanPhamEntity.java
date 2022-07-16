package com.quanlydoanhthu.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "DonHang_SanPham")
public class DonHangSanPhamEntity {
	@EmbeddedId
	private CompositeKey idKey;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @MapsId("idDonHangLong")
    @JoinColumn(name = "id_donhang")
    DonHangEntity donHangEntity;

	@JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @MapsId("idSanPhamLong")
    @JoinColumn(name = "id_sanpham")
    SanPhamEntity sanPhamEntity;
	
	@Column(name = "SoLuong")
	private Integer soLuongInteger;
	
	@Column(name = "Gia")
	private Long giaLong;
	
	public Long getGiaLong() {
		return giaLong;
	}

	public void setGiaLong(Long giaLong) {
		this.giaLong = giaLong;
	}

	public Integer getSoLuongInteger() {
		return soLuongInteger;
	}

	public void setSoLuongInteger(Integer soLuongInteger) {
		this.soLuongInteger = soLuongInteger;
	}

	public CompositeKey getIdKey() {
		return idKey;
	}

	public void setIdKey(CompositeKey idKey) {
		this.idKey = idKey;
	}

	public DonHangEntity getDonHangEntity() {
		return donHangEntity;
	}

	public void setDonHangEntity(DonHangEntity donHangEntity) {
		this.donHangEntity = donHangEntity;
	}

	public SanPhamEntity getSanPhamEntity() {
		return sanPhamEntity;
	}

	public void setSanPhamEntity(SanPhamEntity sanPhamEntity) {
		this.sanPhamEntity = sanPhamEntity;
	}
	
	
	
	
	
}
