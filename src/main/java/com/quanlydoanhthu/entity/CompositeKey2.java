package com.quanlydoanhthu.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CompositeKey2 implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "id_nhaphang")
	Long idNhapHangLong;
	@Column(name = "id_sanpham")
	Long idSanPhamLong;
	
	
	public Long getIdNhapHangLong() {
		return idNhapHangLong;
	}
	public void setIdNhapHangLong(Long idNhapHangLong) {
		this.idNhapHangLong = idNhapHangLong;
	}
	public Long getIdSanPhamLong() {
		return idSanPhamLong;
	}
	public void setIdSanPhamLong(Long idSanPhamLong) {
		this.idSanPhamLong = idSanPhamLong;
	}
	
	
	
}
