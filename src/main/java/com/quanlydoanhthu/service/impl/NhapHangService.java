package com.quanlydoanhthu.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quanlydoanhthu.converter.NhapHangConverter;
import com.quanlydoanhthu.dto.NhapHangDTO;
import com.quanlydoanhthu.entity.NhapHangEntity;
import com.quanlydoanhthu.entity.NhapHangSanPhamEntity;
import com.quanlydoanhthu.repository.NhapHangRepository;
import com.quanlydoanhthu.repository.NhapHangSanPhamRepository;
import com.quanlydoanhthu.service.dao.INhapHangService;

@Service
public class NhapHangService implements INhapHangService {
	@Autowired
	NhapHangRepository nhapHangRepository;
	@Autowired
	NhapHangConverter nhapHangConverter;
	@Autowired
	NhapHangSanPhamRepository nhapHangSanPhamRepository;

	@Override
	public List<NhapHangDTO> findAll() {
		List<NhapHangDTO> nhapHangDTOs = new ArrayList<NhapHangDTO>();
		List<NhapHangEntity> nhapHangEntities = nhapHangRepository.findAll();
		NhapHangDTO nhapHangDTO = new NhapHangDTO();

		for (NhapHangEntity nhapHangEntity : nhapHangEntities) {
			nhapHangDTO = nhapHangConverter.toDTO(nhapHangEntity);
			nhapHangDTOs.add(nhapHangDTO);
		}
		return nhapHangDTOs;
	}

	@Override
	public NhapHangDTO findById(Long idLong) {
		NhapHangEntity nhapHangEntity = nhapHangRepository.findOne(idLong);
		return nhapHangConverter.toDTO(nhapHangEntity);
	}

	@Override
	@Transactional
	public NhapHangDTO save(NhapHangDTO nhapHangDTO) {

		return nhapHangDTO;
	}

	@Transactional
	@Override
	public NhapHangDTO save1(NhapHangDTO nhapHangDTO) {
		NhapHangEntity nhapHangEntity = new NhapHangEntity();
		nhapHangEntity = nhapHangConverter.toEntity(nhapHangDTO);
		nhapHangEntity = nhapHangRepository.save(nhapHangEntity);
		String string = nhapHangEntity.getCreatedByString();
		Date date = nhapHangEntity.getCreatedDate();
		NhapHangDTO nhapHangDTO2 = new NhapHangDTO();
		nhapHangDTO2 = nhapHangDTO;
		nhapHangDTO2.setId(nhapHangEntity.getId());
		for (int i = 0; i < nhapHangDTO.getSoLuongSanPham(); i++) {
			NhapHangEntity nhapHangEntity1 = new NhapHangEntity();
			nhapHangDTO2.setSoLuongNhap(nhapHangDTO.getSoLuongNhapList().get(i));
			nhapHangDTO2.setIdSanPhamLong(nhapHangDTO.getIdSanPhamList().get(i));
			nhapHangEntity = nhapHangConverter.toEntity(nhapHangDTO2, nhapHangEntity1);
			nhapHangEntity.setCreatedByString(string);
			nhapHangEntity.setCreatedDate(date);
			for (NhapHangSanPhamEntity nhapHangSanPhamEntity : nhapHangEntity.getNhapHangSanPhamEntities()) {
				nhapHangSanPhamEntity.setNhapHangEntity(nhapHangEntity);
				nhapHangSanPhamRepository.save(nhapHangSanPhamEntity);
			}
		}
		return nhapHangConverter.toDTO(nhapHangRepository.findOne(nhapHangEntity.getId()));
	}

}
