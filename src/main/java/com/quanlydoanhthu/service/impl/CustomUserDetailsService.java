package com.quanlydoanhthu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.quanlydoanhthu.constant.SystemConstant;
import com.quanlydoanhthu.converter.NhanVienConverter;
import com.quanlydoanhthu.dto.MyUser;
import com.quanlydoanhthu.entity.NguoiDungEntity;
import com.quanlydoanhthu.entity.PhanQuyenEntity;
import com.quanlydoanhthu.repository.NguoiDungRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
	private NguoiDungRepository nguoiDungRepository;
	@Autowired
	private NhanVienConverter nhanVienConverter;
	
	@Override
	public UserDetails loadUserByUsername(String tenDangNhapString) throws UsernameNotFoundException {
		NguoiDungEntity nguoiDungEntity = nguoiDungRepository.findOneByTenDangNhapStringAndTrangThai(tenDangNhapString, SystemConstant.ACTIVE_STATUS);
		if (nguoiDungEntity == null) {
			throw new UsernameNotFoundException("User not found");
		}
		List<GrantedAuthority> authorities = new ArrayList<>();
		String phanquyenString = "";
		for(PhanQuyenEntity phanQuyenEntity: nguoiDungEntity.getPhanQuyenEntities()) {
			phanquyenString = phanQuyenEntity.getMaQuyenString();
			authorities.add(new SimpleGrantedAuthority(phanQuyenEntity.getMaQuyenString()));
		}
		
		MyUser myUser = new MyUser(nguoiDungEntity.getTenDangNhapString(), nguoiDungEntity.getMatKhauString(),
				true, true, true, true, authorities);
		myUser.setFullNameString(nguoiDungEntity.getNhanVienEntity().getHoVaTenString());
		myUser.setPhanQuyenString(phanquyenString);
		myUser.setNhanVienDTO(nhanVienConverter.toDTO(nguoiDungEntity.getNhanVienEntity()));
		return myUser;
	}
	
}
