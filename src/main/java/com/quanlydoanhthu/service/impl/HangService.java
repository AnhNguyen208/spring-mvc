package com.quanlydoanhthu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quanlydoanhthu.converter.HangConverter;
import com.quanlydoanhthu.dto.HangDTO;
import com.quanlydoanhthu.entity.HangEntity;
import com.quanlydoanhthu.repository.HangRepository;
import com.quanlydoanhthu.service.dao.IHangService;

@Service
public class HangService implements IHangService {
	@Autowired
	HangRepository hangRepository;
	@Autowired 
	HangConverter hangConverter;

	@Override
	public List<HangDTO> findAll() {
		List<HangEntity> hangEntities = hangRepository.findAll();
		List<HangDTO> hangDTOs = new ArrayList<HangDTO>();
		HangDTO hangDTO = new HangDTO();
		for(HangEntity hangEntity: hangEntities) {
			hangDTO = hangConverter.toDTO(hangEntity);
			hangDTOs.add(hangDTO);
		}
		return hangDTOs;
	}
	

}
