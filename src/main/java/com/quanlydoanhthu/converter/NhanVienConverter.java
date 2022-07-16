package com.quanlydoanhthu.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.quanlydoanhthu.dto.NhanVienDTO;
import com.quanlydoanhthu.entity.NhanVienEntity;

@Component
public class NhanVienConverter {
	@Autowired
	ChucVuConverter chucVuConverter;
	
	public NhanVienDTO toDTO(NhanVienEntity nhanVienEntity) {
		NhanVienDTO nhanVienDTO = new NhanVienDTO(); 
		nhanVienDTO.setId(nhanVienEntity.getId());
		nhanVienDTO.setHoVaTenString(nhanVienEntity.getHoVaTenString());
		nhanVienDTO.setSdtString(nhanVienEntity.getSdtString());
		nhanVienDTO.setAnhDaiDienString(nhanVienEntity.getAnhDaiDienString());
		nhanVienDTO.setEmailString(nhanVienEntity.getEmailString());
		nhanVienDTO.setDiaChiString(nhanVienEntity.getDiaChiString());
		nhanVienDTO.setMaChucVuString(nhanVienEntity.getChucVuEntity().getMaChucVuString());
		nhanVienDTO.setChucVuDTO(chucVuConverter.toDTO(nhanVienEntity.getChucVuEntity()));;
		return nhanVienDTO;
	}
	
	public NhanVienEntity toEntity(NhanVienDTO nhanVienDTO) {
		NhanVienEntity nhanVienEntity = new NhanVienEntity();
		nhanVienEntity.setHoVaTenString(nhanVienDTO.getHoVaTenString());
		nhanVienEntity.setSdtString(nhanVienDTO.getSdtString());
		nhanVienEntity.setAnhDaiDienString(nhanVienDTO.getAnhDaiDienString());
		nhanVienEntity.setDiaChiString(nhanVienDTO.getDiaChiString());
		nhanVienEntity.setEmailString(nhanVienDTO.getEmailString());
		return nhanVienEntity;
	}
	
	public NhanVienEntity toEntity(NhanVienEntity nhanVienEntity, NhanVienDTO nhanVienDTO) {
		nhanVienEntity.setHoVaTenString(nhanVienDTO.getHoVaTenString());
		nhanVienEntity.setSdtString(nhanVienDTO.getSdtString());
		nhanVienEntity.setAnhDaiDienString(nhanVienDTO.getAnhDaiDienString());
		nhanVienEntity.setDiaChiString(nhanVienDTO.getDiaChiString());
		nhanVienEntity.setEmailString(nhanVienDTO.getEmailString());
		return nhanVienEntity;
	}
	
}
