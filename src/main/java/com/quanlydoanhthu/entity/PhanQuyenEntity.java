package com.quanlydoanhthu.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Phan_Quyen")
public class PhanQuyenEntity extends BaseEntity{
	
	@Column(name = "TenQuyen")
	private String tenQuyenString;

	@Column(name = "MaQuyen")
	private String maQuyenString;
	
	public List<NguoiDungEntity> getUsers() {
		return users;
	}

	public void setUsers(List<NguoiDungEntity> users) {
		this.users = users;
	}

	@ManyToMany(mappedBy = "phanQuyenEntities")
    private List<NguoiDungEntity> users = new ArrayList<>();

	public String getTenQuyenString() {
		return tenQuyenString;
	}

	public void setTenQuyenString(String tenQuyenString) {
		this.tenQuyenString = tenQuyenString;
	}

	public String getMaQuyenString() {
		return maQuyenString;
	}

	public void setMaQuyenString(String maQuyenString) {
		this.maQuyenString = maQuyenString;
	}
	
}
