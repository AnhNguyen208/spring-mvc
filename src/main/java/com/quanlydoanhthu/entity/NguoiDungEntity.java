package com.quanlydoanhthu.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Nguoi_Dung")
public class NguoiDungEntity extends BaseEntity{

	@Column(name = "TenDangNhap")
	private String tenDangNhapString;

	@Column(name = "MatKhau")
	private String matKhauString;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "idNDNhanVien", referencedColumnName = "id")
    private NhanVienEntity nhanVienEntity;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "NguoiDung_PhanQuyen", joinColumns = @JoinColumn(name = "idNguoiDung"), 
	inverseJoinColumns = @JoinColumn(name = "idPhanQuyen"))
	private List<PhanQuyenEntity> phanQuyenEntities = new ArrayList<>();

	public List<PhanQuyenEntity> getPhanQuyenEntities() {
		return phanQuyenEntities;
	}

	public void setPhanQuyenEntities(List<PhanQuyenEntity> phanQuyenEntities) {
		this.phanQuyenEntities = phanQuyenEntities;
	}

	public String getTenDangNhapString() {
		return tenDangNhapString;
	}

	public void setTenDangNhapString(String tenDangNhapString) {
		this.tenDangNhapString = tenDangNhapString;
	}

	public String getMatKhauString() {
		return matKhauString;
	}

	public void setMatKhauString(String matKhauString) {
		this.matKhauString = matKhauString;
	}

	public NhanVienEntity getNhanVienEntity() {
		return nhanVienEntity;
	}

	public void setNhanVienEntity(NhanVienEntity nhanVienEntity) {
		this.nhanVienEntity = nhanVienEntity;
	}
}
