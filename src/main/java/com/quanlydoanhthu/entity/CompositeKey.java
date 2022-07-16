package com.quanlydoanhthu.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CompositeKey implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "id_donhang")
	Long idDonHangLong;
	@Column(name = "id_sanpham")
	Long idSanPhamLong;
	
	public Long getIdDonHangLong() {
		return idDonHangLong;
	}
	public void setIdDonHangLong(Long idDonHangLong) {
		this.idDonHangLong = idDonHangLong;
	}
	public Long getIdSanPhamLong() {
		return idSanPhamLong;
	}
	public void setIdSanPhamLong(Long idSanPhamLong) {
		this.idSanPhamLong = idSanPhamLong;
	}
	
	
	
}
