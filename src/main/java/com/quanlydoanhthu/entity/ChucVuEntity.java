package com.quanlydoanhthu.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Chuc_Vu")
public class ChucVuEntity extends BaseEntity{
	
	@Column(name = "TenChucVu")
	private String tenChucVuString;

	@Column(name = "MaChucVu")
	private String maChucVuString;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "chucVuEntity")
	private List<NhanVienEntity> nhanVienEntities = new ArrayList<NhanVienEntity>();
	
	public List<NhanVienEntity> getNhanVienEntities() {
		return nhanVienEntities;
	}

	public void setNhanVienEntities(List<NhanVienEntity> nhanVienEntities) {
		this.nhanVienEntities = nhanVienEntities;
	}

	public List<NguoiDungEntity> getUsers() {
		return users;
	}

	public void setUsers(List<NguoiDungEntity> users) {
		this.users = users;
	}

	@ManyToMany(mappedBy = "phanQuyenEntities")
    private List<NguoiDungEntity> users = new ArrayList<>();

	public String getTenChucVuString() {
		return tenChucVuString;
	}

	public void setTenChucVuString(String tenChucVuString) {
		this.tenChucVuString = tenChucVuString;
	}

	public String getMaChucVuString() {
		return maChucVuString;
	}

	public void setMaChucVuString(String maChucVuString) {
		this.maChucVuString = maChucVuString;
	}

	
}
