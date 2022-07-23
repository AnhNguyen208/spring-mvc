package com.quanlydoanhthu.dto;

import java.util.List;

public class NhapHangDTO extends AbstractDTO<NhapHangDTO> {
	private List<Long> idSanPhamList;
	private List<SanPhamDTO> thongTinNhapHangDtos;
	private Long idSanPhamLong;
	private List<Integer> soLuongNhapList;
	private int soLuongNhap;
	private int soLuongSanPham;
	private Long idNhanVienNhapHang;
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

	public Long getIdSanPhamLong() {
		return idSanPhamLong;
	}

	public void setIdSanPhamLong(Long idSanPhamLong) {
		this.idSanPhamLong = idSanPhamLong;
	}

	public List<SanPhamDTO> getThongTinNhapHangDtos() {
		return thongTinNhapHangDtos;
	}

	public void setThongTinNhapHangDtos(List<SanPhamDTO> thongTinNhapHangDtos) {
		this.thongTinNhapHangDtos = thongTinNhapHangDtos;
	}

	public List<Integer> getSoLuongNhapList() {
		return soLuongNhapList;
	}

	public void setSoLuongNhapList(List<Integer> soLuongNhapList) {
		this.soLuongNhapList = soLuongNhapList;
	}

	public int getSoLuongNhap() {
		return soLuongNhap;
	}

	public void setSoLuongNhap(int soLuongNhap) {
		this.soLuongNhap = soLuongNhap;
	}

	public void setTongTienDonHang(Long tongTienDonHang) {
		this.tongTienDonHang = tongTienDonHang;
	}

	public Long getTongTienDonHang() {
		return tongTienDonHang;
	}

	public void setTongTienDonHang(List<SanPhamDTO> thongTinDonHangDtos) {
		this.tongTienDonHang = (long) 0;
		for (SanPhamDTO sanPhamDTO : thongTinDonHangDtos) {
			this.tongTienDonHang = this.tongTienDonHang + (sanPhamDTO.getSoLuongNhap() * sanPhamDTO.getGiaNhapLong1());
		}
		this.tongTienDonHang = this.tongTienDonHang - this.chietKhauLong;
	}

	public int getSoLuongSanPham() {
		return soLuongSanPham;
	}

	public void setSoLuongSanPham(int soLuongSanPham) {
		this.soLuongSanPham = soLuongSanPham;
	}

	public Long getIdNhanVienNhapHang() {
		return idNhanVienNhapHang;
	}

	public void setIdNhanVienNhapHang(Long idNhanVienNhapHang) {
		this.idNhanVienNhapHang = idNhanVienNhapHang;
	}

}
