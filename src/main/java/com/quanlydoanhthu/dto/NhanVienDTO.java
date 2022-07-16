package com.quanlydoanhthu.dto;

import java.sql.Date;

public class NhanVienDTO extends AbstractDTO<NhanVienDTO>{
	private String hoVaTenString;
	private String anhDaiDienString;
	private String sdtString;
	private Date ngaySinhDate;
	private String emailString;
	private String diaChiString;
	private String maChucVuString;
	private ChucVuDTO chucVuDTO;
	private Long idNguoiDungLong;
	private Long doanhThuLong;
	
	
	public Long getDoanhThuLong() {
		return doanhThuLong;
	}
	public void setDoanhThuLong(Long doanhThuLong) {
		this.doanhThuLong = doanhThuLong;
	}
	public String getMaChucVuString() {
		return maChucVuString;
	}
	public void setMaChucVuString(String maChucVuString) {
		this.maChucVuString = maChucVuString;
	}
	
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
	
	public ChucVuDTO getChucVuDTO() {
		return chucVuDTO;
	}
	public void setChucVuDTO(ChucVuDTO chucVuDTO) {
		this.chucVuDTO = chucVuDTO;
	}
	public Long getIdNguoiDungLong() {
		return idNguoiDungLong;
	}
	public void setIdNguoiDungLong(Long idNguoiDungLong) {
		this.idNguoiDungLong = idNguoiDungLong;
	}
	
	
}
