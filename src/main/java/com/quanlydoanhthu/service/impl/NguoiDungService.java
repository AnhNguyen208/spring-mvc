package com.quanlydoanhthu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quanlydoanhthu.converter.NguoiDungConverter;
import com.quanlydoanhthu.dto.MyUser;
import com.quanlydoanhthu.dto.NhanVienDTO;
import com.quanlydoanhthu.entity.NguoiDungEntity;
import com.quanlydoanhthu.repository.NguoiDungRepository;
import com.quanlydoanhthu.service.dao.INguoiDungService;

@Service
public class NguoiDungService implements INguoiDungService{
	@Autowired
	private NguoiDungRepository nguoiDungRepository;
	@Autowired
	private NguoiDungConverter nguoiDungConverter;
	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Override
	public MyUser save(NhanVienDTO nhanVienDTO) {
		NguoiDungEntity nguoiDungEntity = nguoiDungConverter.toEntity(nhanVienDTO);
		nguoiDungRepository.save(nguoiDungEntity);
		return (MyUser) customUserDetailsService.loadUserByUsername(nhanVienDTO.getEmailString());
	}
	
}
