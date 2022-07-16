package com.quanlydoanhthu.converter;

import org.springframework.stereotype.Component;

import com.quanlydoanhthu.dto.HangDTO;
import com.quanlydoanhthu.entity.HangEntity;

@Component
public class HangConverter {

	public HangDTO toDTO(HangEntity hangEntity) {
		HangDTO hangDTO = new HangDTO();
		hangDTO.setTenHangString(hangEntity.getTenHangString());
		hangDTO.setAnhDaiDienString(hangEntity.getAnhDaiDienString());
		hangDTO.setDiaChiString(hangEntity.getDiaChiString());
		hangDTO.setSdtString(hangEntity.getSdtString());
		hangDTO.setEmailString(hangEntity.getEmailString());
		return hangDTO;
	}

	public HangEntity toEntity(HangDTO hangDTO) {
		HangEntity hangEntity = new HangEntity();
		return hangEntity;
	}
}
