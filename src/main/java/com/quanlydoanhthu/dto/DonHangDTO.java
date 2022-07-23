package com.quanlydoanhthu.dto;

import java.util.List;

public class DonHangDTO extends AbstractDTO<DonHangDTO>{
	private List<Long> idSanPhamList;
	private String thongTinKhachHangString;
	private List<SanPhamDTO> thongTinDonHangDtos;
	private Long idSanPhamLong;
	private List<Integer> soLuongBanList;
	private int soLuongBan;
	private int soLuongSanPham;
	private Long idNhanVienBanHang;
	private String tenNhanVienString;
	private Long tongTienDonHang;
	private Long chietKhauLong;
	
	public Long getChietKhauLong() {
		return chietKhauLong;
	}
	public void setChietKhauLong(Long chietKhauLong) {
		this.chietKhauLong = chietKhauLong;
	}
	public String getTenNhanVienString() {
		return tenNhanVienString;
	}
	public void setTenNhanVienString(String tenNhanVienString) {
		this.tenNhanVienString = tenNhanVienString;
	}
	public List<Long> getIdSanPhamList() {
		return idSanPhamList;
	}
	public void setIdSanPhamList(List<Long> list) {
		this.idSanPhamList = list;
	}
	public List<Integer> getSoLuongBanList() {
		return soLuongBanList;
	}
	public void setSoLuongBanList(List<Integer> soLuongBanList) {
		this.soLuongBanList = soLuongBanList;
	}
	public Long getIdSanPhamLong() {
		return idSanPhamLong;
	}
	public void setIdSanPhamLong(Long idSanPhamLong) {
		this.idSanPhamLong = idSanPhamLong;
	}
	
	public int getSoLuongBan() {
		return soLuongBan;
	}
	public void setSoLuongBan(int soLuongBan) {
		this.soLuongBan = soLuongBan;
	}
	public Long getTongTienDonHang() {
		return tongTienDonHang;
	}
	public void setTongTienDonHang(List<SanPhamDTO> thongTinDonHangDtos) {
		this.tongTienDonHang = (long) 0;
		for(SanPhamDTO sanPhamDTO:thongTinDonHangDtos) {
			this.tongTienDonHang = this.tongTienDonHang + (sanPhamDTO.getSoLuongBan()*sanPhamDTO.getGiaBanLong1());
		}
		this.tongTienDonHang = this.tongTienDonHang - this.chietKhauLong;
		
	}
	public int getSoLuongSanPham() {
		return soLuongSanPham;
	}
	public void setSoLuongSanPham(int soLuongSanPham) {
		this.soLuongSanPham = soLuongSanPham;
	}
	public String getThongTinKhachHangString() {
		return thongTinKhachHangString;
	}
	public void setThongTinKhachHangString(String thongTinKhachHangString) {
		this.thongTinKhachHangString = thongTinKhachHangString;
	}
	public List<SanPhamDTO> getThongTinDonHangDtos() {
		return thongTinDonHangDtos;
	}
	public void setThongTinDonHangDtos(List<SanPhamDTO> thongTinDonHangDtos) {
		this.thongTinDonHangDtos = thongTinDonHangDtos;
	}
	public Long getIdNhanVienBanHang() {
		return idNhanVienBanHang;
	}
	public void setIdNhanVienBanHang(Long idNhanVienBanHang) {
		this.idNhanVienBanHang = idNhanVienBanHang;
	}
}
