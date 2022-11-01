package com.quanlydoanhthu.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.quanlydoanhthu.dto.NhanVienDTO;
import com.quanlydoanhthu.entity.NguoiDungEntity;
import com.quanlydoanhthu.entity.PhanQuyenEntity;
import com.quanlydoanhthu.repository.PhanQuyenRepository;

@Component
public class NguoiDungConverter {
	@Autowired
	private NhanVienConverter nhanVienConverter;
	@Autowired
	private PhanQuyenRepository phanQuyenRepository;
	
	public NguoiDungEntity toEntity(NhanVienDTO nhanVienDTO) {
		NguoiDungEntity nguoiDungEntity = new NguoiDungEntity();
		nguoiDungEntity.setTenDangNhapString(nhanVienDTO.getEmailString());
		nguoiDungEntity.setMatKhauString("123456");
		nguoiDungEntity.setNhanVienEntity(nhanVienConverter.toEntity(nhanVienDTO));
		List<PhanQuyenEntity> phanQuyenEntities = new ArrayList<PhanQuyenEntity>();
		if(nhanVienDTO.getMaChucVuString() == "GD") {
			PhanQuyenEntity phanQuyenEntity = phanQuyenRepository.findOne((long) 1);
			phanQuyenEntities.add(phanQuyenEntity);
		}
		else if(nhanVienDTO.getMaChucVuString() == "QLK") {
			PhanQuyenEntity phanQuyenEntity = phanQuyenRepository.findOne((long) 2);
			phanQuyenEntities.add(phanQuyenEntity);
		}
		else if(nhanVienDTO.getMaChucVuString() == "BH") {
			PhanQuyenEntity phanQuyenEntity = phanQuyenRepository.findOne((long) 3);
			phanQuyenEntities.add(phanQuyenEntity);
		}
		nguoiDungEntity.setPhanQuyenEntities(phanQuyenEntities);
		return nguoiDungEntity;
	}
}
