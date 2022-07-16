package com.quanlydoanhthu.converter;

import org.springframework.stereotype.Component;

import com.quanlydoanhthu.dto.LoaiSPDTO;
import com.quanlydoanhthu.entity.LoaiSPEntity;

@Component
public class LoaiSPConverter {

	public LoaiSPDTO toDTO(LoaiSPEntity loaiSPEntity) {
		LoaiSPDTO loaiSPDTO = new LoaiSPDTO();
		loaiSPDTO.setId(loaiSPEntity.getId());
		loaiSPDTO.setTenLoaiSPString(loaiSPEntity.getTenLoaiSPString());
		loaiSPDTO.setMaLoaiSPString(loaiSPEntity.getMaSP());
		return loaiSPDTO;
	}

	public LoaiSPEntity toEntity(LoaiSPDTO loaiSPDTO) {
		LoaiSPEntity loaiSPEntity = new LoaiSPEntity();
		return loaiSPEntity;
	}
}
