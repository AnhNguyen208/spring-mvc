package com.quanlydoanhthu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quanlydoanhthu.converter.LoaiSPConverter;
import com.quanlydoanhthu.dto.LoaiSPDTO;
import com.quanlydoanhthu.entity.LoaiSPEntity;
import com.quanlydoanhthu.repository.LoaiSPRepository;
import com.quanlydoanhthu.service.dao.ILoaiSPService;

@Service
public class LoaiSPService implements ILoaiSPService {
	@Autowired
	LoaiSPRepository loaiSPRepository;
	@Autowired 
	LoaiSPConverter loaiSPConverter;

	@Override
	public List<LoaiSPDTO> findAll() {
		List<LoaiSPEntity>loaiSPEntities = loaiSPRepository.findAll();
		List<LoaiSPDTO> loaiSPDTOs = new ArrayList<LoaiSPDTO>();
		LoaiSPDTO loaiSPDTO = new LoaiSPDTO();
		for(LoaiSPEntity loaiSPEntity: loaiSPEntities) {
			loaiSPDTO = loaiSPConverter.toDTO(loaiSPEntity);
			loaiSPDTOs.add(loaiSPDTO);
		}
		return loaiSPDTOs;
	}
	

}
