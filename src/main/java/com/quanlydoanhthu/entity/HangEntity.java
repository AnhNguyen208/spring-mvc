package com.quanlydoanhthu.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "hang")
public class HangEntity extends BaseEntity{
	@Column(name = "TenHang")
	private String tenHangString;
	
	@Column(name = "AnhDaiDienHang")
	private String anhDaiDienString;
	
	@Column(name = "DiaChi")
	private String diaChiString;
	
	@Column(name = "SDT")
	private String sdtString;
	
	@Column(name = "Email")
	private String emailString;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "hangEntity")
	private List<SanPhamEntity> sanPhamEntities = new ArrayList<SanPhamEntity>();

	
	public String getTenHangString() {
		return tenHangString;
	}

	public void setTenHangString(String tenHangString) {
		this.tenHangString = tenHangString;
	}

	public String getAnhDaiDienString() {
		return anhDaiDienString;
	}

	public void setAnhDaiDienString(String anhDaiDienString) {
		this.anhDaiDienString = anhDaiDienString;
	}

	public String getDiaChiString() {
		return diaChiString;
	}

	public void setDiaChiString(String diaChiString) {
		this.diaChiString = diaChiString;
	}

	public String getSdtString() {
		return sdtString;
	}

	public void setSdtString(String sdtString) {
		this.sdtString = sdtString;
	}

	public String getEmailString() {
		return emailString;
	}

	public void setEmailString(String emailString) {
		this.emailString = emailString;
	}

	public List<SanPhamEntity> getSanPhamEntities() {
		return sanPhamEntities;
	}

	public void setSanPhamEntities(List<SanPhamEntity> sanPhamEntities) {
		this.sanPhamEntities = sanPhamEntities;
	}
}
