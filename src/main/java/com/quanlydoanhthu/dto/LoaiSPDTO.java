package com.quanlydoanhthu.dto;

public class LoaiSPDTO extends AbstractDTO<LoaiSPDTO>{
	private String tenLoaiSPString;
	private String maLoaiSPString;
	
	public String getTenLoaiSPString() {
		return tenLoaiSPString;
	}
	public void setTenLoaiSPString(String tenLoaiSPString) {
		this.tenLoaiSPString = tenLoaiSPString;
	}
	public String getMaLoaiSPString() {
		return maLoaiSPString;
	}
	public void setMaLoaiSPString(String maLoaiSPString) {
		this.maLoaiSPString = maLoaiSPString;
	}
}
