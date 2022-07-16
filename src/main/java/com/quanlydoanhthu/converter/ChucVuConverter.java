package com.quanlydoanhthu.converter;

import org.springframework.stereotype.Component;

import com.quanlydoanhthu.dto.ChucVuDTO;
import com.quanlydoanhthu.entity.ChucVuEntity;

@Component
public class ChucVuConverter {
	public ChucVuDTO toDTO(ChucVuEntity chucvuEntity) {
		ChucVuDTO chucVuDTO = new ChucVuDTO();
		chucVuDTO.setId(chucvuEntity.getId());
		chucVuDTO.setTenChucVuString(chucvuEntity.getTenChucVuString());
		chucVuDTO.setMaChucVuString(chucvuEntity.getMaChucVuString());
		return chucVuDTO;
	}
	
	public ChucVuEntity toEntity(ChucVuDTO chucVuDTO) {
		ChucVuEntity chucVuEntity = new ChucVuEntity();
		chucVuEntity.setTenChucVuString(chucVuDTO.getTenChucVuString());
		chucVuEntity.setMaChucVuString(chucVuDTO.getMaChucVuString());
		return chucVuEntity;
	}
}
