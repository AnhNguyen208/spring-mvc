package com.quanlydoanhthu.dto;

import java.util.List;

public class NhapHangDTO2 extends AbstractDTO<NhapHangDTO2>{
	private List<Long> idSanPhamList;
	private String thongTinNhaCungCapString;
	private List<Integer> soLuongNhapList;
	private Long idNhanVienNhapHang;
	private int soLuongSanPham;
	
	
	public int getSoLuongSanPham() {
		return soLuongSanPham;
	}
	public void setSoLuongSanPham(int soLuongSanPham) {
		this.soLuongSanPham = soLuongSanPham;
	}
	public List<Integer> getSoLuongNhapList() {
		return soLuongNhapList;
	}
	public void setSoLuongNhapList(List<Integer> soLuongNhapList) {
		this.soLuongNhapList = soLuongNhapList;
	}
	public List<Long> getIdSanPhamList() {
		return idSanPhamList;
	}
	public void setIdSanPhamList(List<Long> list) {
		this.idSanPhamList = list;
	}
	public String getThongTinNhaCungCapString() {
		return thongTinNhaCungCapString;
	}
	public void setThongTinNhaCungCapString(String thongTinNhaCungCapString) {
		this.thongTinNhaCungCapString = thongTinNhaCungCapString;
	}
	public Long getIdNhanVienNhapHang() {
		return idNhanVienNhapHang;
	}
	public void setIdNhanVienNhapHang(Long idNhanVienNhapHang) {
		this.idNhanVienNhapHang = idNhanVienNhapHang;
	}
	
}
