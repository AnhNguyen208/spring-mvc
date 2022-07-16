package com.quanlydoanhthu.dto;

import java.util.List;

public class DonHangDTO2{
	private List<Long> idSanPhamList;
	private String thongTinKhachHangString;
	private List<Integer> soLuongBanList;
	private Long idNhanVienBanHang;
	private int soLuongSanPham;
	
	public int getSoLuongSanPham() {
		return soLuongSanPham;
	}
	public void setSoLuongSanPham(int soLuongSanPham) {
		this.soLuongSanPham = soLuongSanPham;
	}
	public List<Long> getIdSanPhamList() {
		return idSanPhamList;
	}
	public void setIdSanPhamList(List<Long> idSanPhamList) {
		this.idSanPhamList = idSanPhamList;
	}
	public List<Integer> getSoLuongBanList() {
		return soLuongBanList;
	}
	public void setSoLuongBanList(List<Integer> soLuongBanList) {
		this.soLuongBanList = soLuongBanList;
	}
	public String getThongTinKhachHangString() {
		return thongTinKhachHangString;
	}
	public void setThongTinKhachHangString(String thongTinKhachHangString) {
		this.thongTinKhachHangString = thongTinKhachHangString;
	}
	
	public Long getIdNhanVienBanHang() {
		return idNhanVienBanHang;
	}
	public void setIdNhanVienBanHang(Long idNhanVienBanHang) {
		this.idNhanVienBanHang = idNhanVienBanHang;
	}
}
