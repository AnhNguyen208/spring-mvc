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
@Table(name = "NhapHang_SanPham")
public class NhapHangSanPhamEntity{
	@EmbeddedId
	private CompositeKey2 idKey;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @MapsId("idNhapHangLong")
    @JoinColumn(name = "id_nhaphang")
    NhapHangEntity nhapHangEntity;

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

	public CompositeKey2 getIdKey() {
		return idKey;
	}

	public void setIdKey(CompositeKey2 idKey) {
		this.idKey = idKey;
	}

	public NhapHangEntity getNhapHangEntity() {
		return nhapHangEntity;
	}

	public void setNhapHangEntity(NhapHangEntity nhapHangEntity) {
		this.nhapHangEntity = nhapHangEntity;
	}

	public SanPhamEntity getSanPhamEntity() {
		return sanPhamEntity;
	}

	public void setSanPhamEntity(SanPhamEntity sanPhamEntity) {
		this.sanPhamEntity = sanPhamEntity;
	}
}
