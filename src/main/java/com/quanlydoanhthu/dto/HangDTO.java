package com.quanlydoanhthu.dto;

public class HangDTO extends AbstractDTO<HangDTO>{
	private String tenHangString;
	private String anhDaiDienString;
	private String diaChiString;
	private String sdtString;
	private String emailString;
	
	public String getTenHangString() {
		return tenHangString;
	}
	public void setTenHangString(String tenHangString) {
		this.tenHangString = tenHangString;
	}
	public String getAnhDaiDienString() {
		return anhDaiDienString;
	}
	public void setAnhDaiDienString(String anhDaiDienString) {
		this.anhDaiDienString = anhDaiDienString;
	}
	public String getDiaChiString() {
		return diaChiString;
	}
	public void setDiaChiString(String diaChiString) {
		this.diaChiString = diaChiString;
	}
	public String getSdtString() {
		return sdtString;
	}
	public void setSdtString(String sdtString) {
		this.sdtString = sdtString;
	}
	public String getEmailString() {
		return emailString;
	}
	public void setEmailString(String emailString) {
		this.emailString = emailString;
	}
}
