package com.quanlydoanhthu.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

@SuppressWarnings("serial")
public class MyUser extends User{

	public MyUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}
	
	private String fullNameString;
	private String phanQuyenString;
	private NhanVienDTO nhanVienDTO;
	
	public NhanVienDTO getNhanVienDTO() {
		return nhanVienDTO;
	}

	public void setNhanVienDTO(NhanVienDTO nhanVienDTO) {
		this.nhanVienDTO = nhanVienDTO;
	}

	public String getPhanQuyenString() {
		return phanQuyenString;
	}

	public void setPhanQuyenString(String phanQuyenString) {
		this.phanQuyenString = phanQuyenString;
	}

	public String getFullNameString() {
		return fullNameString;
	}

	public void setFullNameString(String fullNameString) {
		this.fullNameString = fullNameString;
	}	
	
}
