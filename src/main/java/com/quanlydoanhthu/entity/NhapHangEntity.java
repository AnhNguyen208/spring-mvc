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
@Table(name = "Nhap_Hang")
public class NhapHangEntity extends BaseEntity{
    
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="idNhanVien")
	private NhanVienEntity nhanVienEntity;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "nhapHangEntity")
    List<NhapHangSanPhamEntity> nhapHangSanPhamEntities;
	
	@Column(name = "ChietKhau")
	private Long chietKhauLong;
	
	public Long getChietKhauLong() {
		return chietKhauLong;
	}

	public void setChietKhauLong(Long chietKhauLong) {
		this.chietKhauLong = chietKhauLong;
	}
	
	public NhanVienEntity getNhanVienEntity() {
		return nhanVienEntity;
	}

	public void setNhanVienEntity(NhanVienEntity nhanVienEntity) {
		this.nhanVienEntity = nhanVienEntity;
	}

	public List<NhapHangSanPhamEntity> getNhapHangSanPhamEntities() {
		return nhapHangSanPhamEntities;
	}

	public void setNhapHangSanPhamEntities(List<NhapHangSanPhamEntity> nhapHangSanPhamEntities) {
		this.nhapHangSanPhamEntities = nhapHangSanPhamEntities;
	}
	
}
