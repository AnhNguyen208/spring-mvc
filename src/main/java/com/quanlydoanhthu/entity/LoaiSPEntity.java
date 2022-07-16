package com.quanlydoanhthu.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "loaiSP")
public class LoaiSPEntity extends BaseEntity{
	@Column(name = "tenLoaiSP")
	private String tenLoaiSPString;
	
	@Column(name = "maSP")
	private String maSP;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "loaiSPEntity")
	private List<SanPhamEntity> sanPhamEntities = new ArrayList<SanPhamEntity>();

	public List<SanPhamEntity> getSanPhamEntities() {
		return sanPhamEntities;
	}
	public void setSanPhamEntities(List<SanPhamEntity> sanPhamEntities) {
		this.sanPhamEntities = sanPhamEntities;
	}
	public String getTenLoaiSPString() {
		return tenLoaiSPString;
	}
	public void setTenLoaiSPString(String tenLoaiSPString) {
		this.tenLoaiSPString = tenLoaiSPString;
	}
	public String getMaSP() {
		return maSP;
	}
	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}
}
