package com.quanlydoanhthu.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Nhan_Vien")
public class NhanVienEntity extends BaseEntity{

	@Column(name = "HoVaTen")
	private String hoVaTenString;
	
	@Column(name = "AnhDaiDienNV")
	private String anhDaiDienString;

	@Column(name = "SDT")
	private String sdtString;

	@Column(name = "NgaySinh")
	private Date ngaySinhDate;

	@Column(name = "Email")
	private String emailString;

	@Column(name = "DiaChi")
	private String diaChiString;
	
	@OneToOne(mappedBy = "nhanVienEntity", orphanRemoval = true)
    private NguoiDungEntity nguoiDungEntity;
	
	@JsonManagedReference
	@OneToMany(mappedBy="nhanVienEntity")
    private List<DonHangEntity> donHangEntities = new ArrayList<DonHangEntity>();
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idChucVu")
	private ChucVuEntity chucVuEntity;

	public String getHoVaTenString() {
		return hoVaTenString;
	}

	public void setHoVaTenString(String hoVaTenString) {
		this.hoVaTenString = hoVaTenString;
	}

	public String getAnhDaiDienString() {
		return anhDaiDienString;
	}

	public void setAnhDaiDienString(String anhDaiDienString) {
		this.anhDaiDienString = anhDaiDienString;
	}

	public String getSdtString() {
		return sdtString;
	}

	public void setSdtString(String sdtString) {
		this.sdtString = sdtString;
	}

	public Date getNgaySinhDate() {
		return ngaySinhDate;
	}

	public void setNgaySinhDate(Date ngaySinhDate) {
		this.ngaySinhDate = ngaySinhDate;
	}

	public String getEmailString() {
		return emailString;
	}

	public void setEmailString(String emailString) {
		this.emailString = emailString;
	}

	public String getDiaChiString() {
		return diaChiString;
	}

	public void setDiaChiString(String diaChiString) {
		this.diaChiString = diaChiString;
	}
	
	public ChucVuEntity getChucVuEntity() {
		return chucVuEntity;
	}

	public void setChucVuEntity(ChucVuEntity chucVuEntity) {
		this.chucVuEntity = chucVuEntity;
	}

	public NguoiDungEntity getNguoiDungEntity() {
		return nguoiDungEntity;
	}

	public void setNguoiDungEntity(NguoiDungEntity nguoiDungEntity) {
		this.nguoiDungEntity = nguoiDungEntity;
	}

	public List<DonHangEntity> getDonHangEntities() {
		return donHangEntities;
	}

	public void setDonHangEntities(List<DonHangEntity> donHangEntities) {
		this.donHangEntities = donHangEntities;
	}

	
	
	

}
